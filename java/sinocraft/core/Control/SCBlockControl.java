package sinocraft.core.Control;

import sinocraft.core.SCLog;
import sinocraft.core.SCLoader;
import sinocraft.core.Annotation.SCConfig;
import sinocraft.core.Annotation.SCBlock;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.ConfigCategory;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraftforge.common.Property;
// import net.minecraftforge.common.Property.Type;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import net.minecraft.item.ItemBlock;


public class SCBlockControl {
    public static ConfigCategory SCBlockConfig = null;
    public static List<String> SCBlockLoadClasss;

    @SCConfig(Mold = "load", CategoryName = "block")
    public static void loadConfig(ConfigCategory confige) {
        SCBlockConfig = confige;
    }
    /*开始初始化的时候被调用*/
    public static void loadClass() {
        //配置没载入，报错退出
        if (SCBlockConfig == null) {
            SCLog.log("WARNING", "Please load the configuration !");
            return;
        }
        SCBlockLoadClasss = SCLoader.SCLoadClassLists.get("blocks");
        //应该先查找类
        if (SCBlockLoadClasss == null) {
            SCLog.log("WARNING", "Could not find BlockClass!");
            return;
        }
        // 遍历所有方块类
        for (String SCBlockLoadClassName : SCBlockLoadClasss) {
            Class SCBlockLaodClass;
            try {
                // 载入方块类
                SCLog.log("LoadClass :" + SCBlockLoadClassName);
                SCBlockLaodClass = Class.forName(SCBlockLoadClassName);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when LoadClass " + SCBlockLoadClassName + " in SCBlockControl!" + e);
                return;
            }
            Constructor SCBlockConstructor = null;
            // 遍历方法
            Method[] methods = SCBlockLaodClass.getDeclaredMethods();
            for (Method method : methods) {
                // 存在注释
                if (method.isAnnotationPresent(SCBlock.class)) {
                    SCBlock annotation = method.getAnnotation(SCBlock.class);
                    // 若构造函数未获得，获得构造函数
                    if (SCBlockConstructor == null) {
                        try {
                            SCLog.log("get Constructor :" + SCBlockLoadClassName);
                            SCBlockConstructor = SCBlockLaodClass.getConstructor(int.class);
                        } catch (Exception e) {
                            SCLog.log("WARNING", "Error when get Constructor in " + SCBlockLoadClassName + e);
                            return;
                        }
                    }

                    try {
                        SCLog.log("new Instance and Register :" + SCBlockConstructor);
                        // 实例化方块
                        Property BlockProperty = SCBlockConfig.get(annotation.Name()+".ID");
                        if (BlockProperty == null) {
                            BlockProperty = new Property(annotation.Name()+".ID",String.valueOf(annotation.DefaultID()), Property.Type.INTEGER) ;
                            SCBlockConfig.put(annotation.Name()+".ID",BlockProperty);
                        }
                        Block newblock =  (Block)SCBlockConstructor.newInstance(BlockProperty.getInt(annotation.DefaultID()));
                        // 配置一些内容
                        newblock = (Block)method.invoke(null, newblock);
                        // 配置去本地化名称
                        newblock.setUnlocalizedName(annotation.Name());
                        // 配置英文名
                        LanguageRegistry.addName(newblock, annotation.Name());
                        // 注册方块
                        GameRegistry.registerBlock(newblock,ItemBlock.class ,annotation.Name(),"SinoCraft");
                    } catch (Exception e) {
                        SCLog.log("WARNING", "Error when new Instance : " + SCBlockConstructor + e);
                        return;
                    }
                }
            }
        }
    }
}
