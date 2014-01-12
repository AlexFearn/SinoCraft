package sinocraft.core.Control;

import sinocraft.core.SCLog;
import sinocraft.core.SCLoader;
import sinocraft.core.Annotation.SCConfig;
import sinocraft.core.Annotation.SCItem;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.ConfigCategory;
// import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.Property;

import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.annotation.Annotation;


public class SCItemControl {
    public static ConfigCategory SCItemConfig;
    public static List<String> SCItemLoadClasss;

    @SCConfig(Mold = "load", CategoryName = "item")
    public static void loadConfig(ConfigCategory confige) {
        SCItemConfig = confige;
    }

    public static void loadClass() {
        // 检查配置
        if (SCItemConfig == null) {
            SCLog.log("WARNING", "Please load the configuration !");
            return;
        }
        SCItemLoadClasss = SCLoader.SCLoadClassLists.get("items");
        // 检查类是否找到
        if (SCItemLoadClasss == null) {
            SCLog.log("WARNING", "Could not find Item!");
            return;
        }
        // 遍历类
        for (String SCItemLoadClassName : SCItemLoadClasss) {
            // 载入类
            Class SCItemLaodClass;
            try {
                SCLog.log("LoadClass :" + SCItemLoadClassName);
                SCItemLaodClass = Class.forName(SCItemLoadClassName);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when LoadClass " + SCItemLoadClassName + " in SCItemControl!" + e);
                return;
            }
            // 遍历方法
            Method[] methods = SCItemLaodClass.getDeclaredMethods();
            Constructor SCItemConstructor = null;
            for (Method method : methods) {
                // 存在注释
                if (method.isAnnotationPresent(SCItem.class)) {
                    SCItem annotation = method.getAnnotation(SCItem.class);
                    // 若构造函数未获得，获得构造函数
                    if (SCItemConstructor == null) {
                        try {
                            SCLog.log("get Constructor :" + SCItemLoadClassName);
                            SCItemConstructor = SCItemLaodClass.getConstructor(int.class);
                        } catch (Exception e) {
                            SCLog.log("WARNING", "Error when get Constructor in " + SCItemLoadClassName + e);
                            return;
                        }
                    }

                    try {
                        SCLog.log("new Instance and Register :" + SCItemConstructor);
                        // 实例化物品
                        Property ItemProperty = SCItemConfig.get(annotation.Name() + ".ID");
                        if (ItemProperty == null) {
                            ItemProperty = new Property(annotation.Name() + ".ID", String.valueOf(annotation.DefaultID()), Property.Type.INTEGER) ;
                            SCItemConfig.put(annotation.Name() + ".ID", ItemProperty);
                        }
                        Item newitem =  (Item)SCItemConstructor.newInstance(ItemProperty.getInt(annotation.DefaultID()) - 256);
                        // 配置一些内容
                        newitem = (Item)method.invoke(null, newitem);
                        // 配置去本地化名称
                        newitem.setUnlocalizedName(annotation.Name());
                        // 配置英文名
                        LanguageRegistry.addName(newitem, annotation.Name());
                        // 注册物品
                        GameRegistry.registerItem(newitem, annotation.Name(),"SinoCraft");
                    } catch (Exception e) {
                        SCLog.log("WARNING", "Error when new Instance : " + SCItemConstructor + e);
                        return;
                    }
                }
            }


            // if (SCItemLaodClass.isAnnotationPresent(SCItem.class)) {
            //     SCItem annotation = (SCItem)SCItemLaodClass.getAnnotation(SCItem.class);
            //     Constructor SCItemConstructor;
            //     try {
            //         SCLog.log("get Constructor :" + SCItemLoadClassName);
            //         SCItemConstructor = SCItemLaodClass.getConstructor(int.class);
            //     } catch (Exception e) {
            //         SCLog.log("WARNING", "Error when get Constructor in " + SCItemLoadClassName + e);
            //         return;
            //     }
            //     try {
            //         SCLog.log("get new Instance and Register :" + SCItemConstructor);
            //         Item newitem =  (Item)SCItemConstructor.newInstance(annotation.DefaultID());
            //         newitem.setUnlocalizedName(annotation.Name());
            //         GameRegistry.registerItem(newitem, annotation.Name());
            //         LanguageRegistry.addName(newitem, annotation.Name());
            //     } catch (Exception e) {
            //         SCLog.log("WARNING", "Error when new Instance : " + SCItemConstructor + e);
            //         return;
            //     }
            // }
        }
    }
}