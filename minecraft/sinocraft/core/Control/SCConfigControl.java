package sinocraft.core.Control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

import java.lang.Package;

import sinocraft.core.SCLog;
import sinocraft.core.Annotation.SCConfig;

import net.minecraftforge.common.Configuration;

public class SCConfigControl {
    public static Configuration SCConfiguration = null;
    public static List<String> SCConfigClassList = new ArrayList<String>();

    public static void load(File loadFile) {
        if (!loadFile.exists()) {
            try {
                SCLog.log("open sinocraft.log");
                loadFile.createNewFile();
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when open sinocraft.log");
                return;
            }
        }
        SCConfiguration = new Configuration(loadFile);
        /* 添加需要调取配置的方法列表 */
        SCConfigClassList.add("sinocraft.core.SCLog");
        SCConfigClassList.add("sinocraft.core.Control.SCBlockControl");
        SCConfigClassList.add("sinocraft.core.Control.SCItemControl");


        /*遍历注解了laod配置的方法*/
        Class<?> SCConfigLaodClass = null;
        for (String SCConfigClass : SCConfigClassList) {
            try {
                SCLog.log("getClass :" + SCConfigClass);
                SCConfigLaodClass = Class.forName(SCConfigClass);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCConfigClass + " in SCConfigControl!");
                return;
            }
            Method[] methods = SCConfigLaodClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(SCConfig.class)) {
                    SCConfig annotation = method.getAnnotation(SCConfig.class);
                    if (annotation.Mold().equals("load"))
                        try {
                            SCLog.log("call " + method.getName() + " in " + SCConfigClass);
                            method.invoke(null, SCConfiguration.getCategory(annotation.CategoryName()));
                        } catch (Exception e) {
                            SCLog.log("WARNING", "Error when call ConfigAnnotation in " + SCConfigClass  + " Method:" + method.toGenericString());
                            return ;
                        }
                }
            }
        }
    }
    public static void save() {
        if (SCConfiguration == null) {
            SCLog.log("WARNING", "Error unfinished load ! in SCConfiguration");
            return;
        }

        // /*遍历注解了save配置的方法*/
        Class<?> SCConfigLaodClass = null;
        for (String SCConfigClass : SCConfigClassList) {
            try {
                SCLog.log("getClass :" + SCConfigClass);
                SCConfigLaodClass = Class.forName(SCConfigClass);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCConfigClass + " in SCConfigControl!");
                return;
            }
            Method[] methods = SCConfigLaodClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(SCConfig.class)) {
                    SCConfig annotation = method.getAnnotation(SCConfig.class);
                    if (annotation.Mold().equals("save"))
                        try {
                            SCLog.log("call " + method.getName()  + " in " + SCConfigClass);
                            method.invoke(null);
                        } catch (Exception e) {
                            SCLog.log("WARNING", "Error when call ConfigAnnotation in " + SCConfigClass  + " Method:" + method.toGenericString());
                            return ;
                        }
                }
            }
        }
        SCConfiguration.save();
    }

}

