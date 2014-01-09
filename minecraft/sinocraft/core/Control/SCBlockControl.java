package sinocraft.core.Control;

import sinocraft.core.SCLog;
import sinocraft.core.SCLoader;
import sinocraft.core.Annotation.SCConfigAnnotation;
import sinocraft.core.Annotation.SCBlockAnnotation;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.ConfigCategory;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.annotation.Annotation;


public class SCBlockControl {
    public static ConfigCategory SCBlockConfig;
    public static List<String> SCBlockLoadClasss;

    @SCConfigAnnotation(Mold = "load", CategoryName = "block")
    public static void loadConfig(ConfigCategory confige) {
        SCBlockConfig = confige;
    }

    public static void loadClass() {
        if (SCBlockConfig == null) {
            SCLog.log("WARNING", "Please load the configuration !");
            return;
        }
        SCBlockLoadClasss = SCLoader.SCLoadClassLists.get("blocks");
        if (SCBlockLoadClasss == null) {
            SCLog.log("WARNING", "Could not find Block!");
            return;
        }
        for (String SCBlockLoadClassName : SCBlockLoadClasss) {
            Class SCBlockLaodClass;
            try {
                SCLog.log("getClass :" + SCBlockLoadClassName);
                SCBlockLaodClass = Class.forName(SCBlockLoadClassName);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCBlockLoadClassName + " in SCBlockControl!" + e);
                return;
            }
            if (SCBlockLaodClass.isAnnotationPresent(SCBlockAnnotation.class)) {
                SCBlockAnnotation annotation = (SCBlockAnnotation)SCBlockLaodClass.getAnnotation(SCBlockAnnotation.class);
                Constructor SCBlockConstructor;
                try {
                    SCLog.log("get Constructor :" + SCBlockLoadClassName);
                    SCBlockConstructor = SCBlockLaodClass.getConstructor(int.class, Material.class);
                } catch (Exception e) {
                    SCLog.log("WARNING", "Error when get Constructor in " + SCBlockLoadClassName + e);
                    return;
                }
                try{
                    SCLog.log("get new Instance and Register :" + SCBlockConstructor);
                    Block newblock =  (Block)SCBlockConstructor.newInstance(annotation.DefaultID(), Material.wood);
                    newblock.setUnlocalizedName(annotation.Name());
                    GameRegistry.registerBlock(newblock, annotation.Name());
                    LanguageRegistry.addName(newblock, annotation.Name());
                } catch (Exception e) {
                    SCLog.log("WARNING", "Error when new Instance : " + SCBlockConstructor + e);
                    return;
                }
            }
        }
    }
}