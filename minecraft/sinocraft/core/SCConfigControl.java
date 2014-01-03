package sinocraft.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;


import net.minecraftforge.common.Configuration;

public class SCConfigControl {
    public static Configuration SCConfiguration = null;
    final static List<String> SCConfigClassList = new ArrayList<String>();

    public static void load(File loadFile) {
        if (!loadFile.exists()) {
            try {
                SCLog.log("Try open SinoCraft.log");
                loadFile.createNewFile();
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when open SinoCraft.log");
                return;
            }
        }
        SCConfiguration = new Configuration(loadFile, false);
        /* 添加需要调取配置的方法列表 */
        SCConfigClassList.add("sinocraft.core.SCLog");

        /*遍历注解了laod配置的方法*/
        Class<?> SCConfigLaodClass = null;
        for (String SCConfigClass : SCConfigClassList) {
            try {
                SCLog.log("Try getClass " + SCConfigClass);
                SCConfigLaodClass = Class.forName(SCConfigClass);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCConfigClass + " in SCConfigControl!");
                return;
            }
            Method[] methods = SCConfigLaodClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(SCConfigAnnotation.class)) {
                    SCConfigAnnotation annotation = method.getAnnotation(SCConfigAnnotation.class);
                    if (annotation.Mold().equals("laod"))
                        try {
                            SCLog.log("Try call " + method.getName());
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
    	if (SCConfiguration == null)
    	{
    		SCLog.log("WARNING", "Error unfinished load ! in SCConfiguration");
    		return;
    	}

        // /*遍历注解了save配置的方法*/
        Class<?> SCConfigLaodClass = null;
        for (String SCConfigClass : SCConfigClassList) {
            try {
                SCLog.log("Try getClass " + SCConfigClass);
                SCConfigLaodClass = Class.forName(SCConfigClass);
            } catch (Exception e) {
                SCLog.log("WARNING", "Error when getClass " + SCConfigClass + " in SCConfigControl!");
                return;
            }
            Method[] methods = SCConfigLaodClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(SCConfigAnnotation.class)) {
                    SCConfigAnnotation annotation = method.getAnnotation(SCConfigAnnotation.class);
                    if (annotation.Mold().equals("save"))
                        try {
                            SCLog.log("Try call " + method.getName());
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

