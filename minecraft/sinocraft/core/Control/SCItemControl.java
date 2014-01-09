package sinocraft.core.Control;

import sinocraft.core.SCLog;
import sinocraft.core.SCLoader;
import sinocraft.core.Annotation.SCConfigAnnotation;
import sinocraft.core.Annotation.SCItemAnnotation;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.ConfigCategory;
// import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.annotation.Annotation;


public class SCItemControl {
    public static ConfigCategory SCItemConfig;
    public static List<String> SCItemLoadClasss;

    @SCConfigAnnotation(Mold = "load", CategoryName = "item")
    public static void loadConfig(ConfigCategory confige) {
        SCItemConfig = confige;
    }

    public static void loadClass() {
        if (SCItemConfig == null) {
            SCLog.log("WARNING", "Please load the configuration !");
            return;
        }
        SCItemLoadClasss = SCLoader.SCLoadClassLists.get("items");
        if (SCItemLoadClasss == null) {
            SCLog.log("WARNING", "Could not find Item!");
            return;
        }
        for (String SCItemLoadClassName : SCItemLoadClasss) {
            SCLog.log(SCItemLoadClassName);
            Class SCItemLaodClass;
            try {
                SCLog.log("getClass :" + SCItemLoadClassName);
                SCItemLaodClass = Class.forName(SCItemLoadClassName);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCItemLoadClassName + " in SCBlockControl!" + e);
                return;
            }

            if (SCItemLaodClass.isAnnotationPresent(SCItemAnnotation.class)) {
                SCItemAnnotation annotation = (SCItemAnnotation)SCItemLaodClass.getAnnotation(SCItemAnnotation.class);
                Constructor SCItemConstructor;
                try {
                    SCLog.log("get Constructor :" + SCItemLoadClassName);
                    SCItemConstructor = SCItemLaodClass.getConstructor(int.class);
                } catch (Exception e) {
                    SCLog.log("WARNING", "Error when get Constructor in " + SCItemLoadClassName + e);
                    return;
                }
                try {
                    SCLog.log("get new Instance and Register :" + SCItemConstructor);
                    Item newitem =  (Item)SCItemConstructor.newInstance(annotation.DefaultID());
                    newitem.setUnlocalizedName(annotation.Name());
                    GameRegistry.registerItem(newitem, annotation.Name());
                    LanguageRegistry.addName(newitem, annotation.Name());
                } catch (Exception e) {
                    SCLog.log("WARNING", "Error when new Instance : " + SCItemConstructor + e);
                    return;
                }
            }
        }
    }
}