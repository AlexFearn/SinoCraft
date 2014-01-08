package sinocraft.core.Control;

import sinocraft.core.SCLog;
import sinocraft.core.SCLoader;
import sinocraft.core.Annotation.SCConfigAnnotation;
import sinocraft.core.Annotation.SCBlockAnnotation;
import sinocraft.blocks.*;

import net.minecraftforge.common.ConfigCategory;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModClassLoader;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.LanguageRegistry;

import java.lang.ClassLoader;
import java.lang.Package;
import java.util.Enumeration;
import java.net.URL;
import java.io.File;
import java.io.FilenameFilter;
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
        if(SCBlockConfig == null)
        {
            SCLog.log("WARNING","Please load the configuration !");
            return;
        }
        SCBlockLoadClasss = SCLoader.SCLoadClassLists.get("blocks");
        for (String SCBlockLoadClassName : SCBlockLoadClasss) {
            SCLog.log(SCBlockLoadClassName);
            Class SCBlockLaodClass;
            try {
                SCLog.log("Try getClass " + SCBlockLoadClassName);
                SCBlockLaodClass = Class.forName(SCBlockLoadClassName);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCBlockLoadClassName + " in SCBlockControl!");
                return;
            }
            SCLog.log("" + SCBlockLaodClass);

            if (SCBlockLaodClass.isAnnotationPresent(SCBlockAnnotation.class)) {
              
                // SCLog.log(""+SCBlockAnnotation.class);
                // SCLog.log(""+SCBlockLaodClass.getAnnotation(SCBlockAnnotation.class));
                SCBlockAnnotation annotation = (SCBlockAnnotation)SCBlockLaodClass.getAnnotation(SCBlockAnnotation.class);
                // SCBlockAnnotation a = (SCBlockAnnotation) SCBlockLaodClass.getAnnotation(SCBlockAnnotation.class);
                Constructor SCBlockConstructor;
                try {
                    SCLog.log("try get Constructor" + SCBlockLoadClassName);
                    // SCBlockConstructor = SCBlockLaodClass.getConstructor(new Class[] { int.class, Material.class});
                    SCBlockConstructor = SCBlockLaodClass.getConstructor(int.class, Material.class);
                    SCLog.log("" + SCBlockConstructor);
                } catch (Exception e) {
                    SCLog.log("WARNING", "Error when get Constructor in " + SCBlockLoadClassName);
                    return;
                }
                try{
                    SCLog.log("try get new Instance and Register :" + SCBlockConstructor);
                    Block newblock =  (Block)SCBlockConstructor.newInstance(annotation.DefaultID(),Material.wood);
                    // SCLog.log("" + SCBlockConstructor.newInstance(500,Material.wood));
                    GameRegistry.registerBlock(newblock,annotation.Name());
                    LanguageRegistry.addName(newblock, annotation.Name());
                }catch (Exception e) {
                    SCLog.log("WARNING", "Error when new Instance : " + SCBlockConstructor);
                    return;
                }
            }
            // Annotation[] annotations = SCBlockLaodClass.getAnnotations();

            // // Annotation[] annotations = clazz.getAnnotations();
            // for (Annotation annotation : annotations) {

            //     Constructor cons = ~SCBlockLaodClass.getConstructor(new class[] {int.class, Material.class});
            //     cons.newInstance(paras);
            //     System.out.println("id= \"" + testA.id() + "\"; name= \"" + testA.name() + "\"; gid = " + testA.gid());
            // }
            // }
            // for (Annotation annotation : methods) {
            //     if (method.isAnnotationPresent(SCConfigAnnotation.class)) {
            //         SCConfigAnnotation annotation = method.getAnnotation(SCConfigAnnotation.class);
            //         if (annotation.Mold().equals("load"))
            //             try {
            //                 SCLog.log("Try call " + method.getName() + " in " + SCBlockClass);
            //                 method.invoke(null, SCConfiguration.getCategory(annotation.CategoryName()));
            //             } catch (Exception e) {
            //                 SCLog.log("WARNING", "Error when call ConfigAnnotation in " + SCBlockClass  + " Method:" + method.toGenericString());
            //                 return ;
            //             }
            //     }
            // }

        }
    }
}