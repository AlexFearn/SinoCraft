package sinocraft.core;

import java.lang.Object;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Property;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import sinocraft.core.Control.SCConfigControl;
import sinocraft.core.Annotation.SCConfigAnnotation;


import static net.minecraftforge.common.Property.Type.BOOLEAN;
import static net.minecraftforge.common.Property.Type.DOUBLE;
import static net.minecraftforge.common.Property.Type.INTEGER;
import static net.minecraftforge.common.Property.Type.STRING;


public class SCLog {

    public static Logger sinocraftLogger = FMLRelaunchLog.log.getLogger().getLogger("SinoCraft");

    public static void log(String format, Object... date) {
        log("INFO", format, date);
    }

    public static void log(String levelstring, String format, Object... date) {
        Level grade = Level.parse(levelstring);
        log(grade, format, date);
    }

    public static void log(Level grade, String format, Object... date) {
        sinocraftLogger.log(grade, format, date);
    }

    public static void setLevel(Level newlevel) {
        sinocraftLogger.setLevel(newlevel);
    }

    public static void EnableFileLog() {
        try {
            FileHandler fh = new FileHandler("SinoCraft.log");
            fh.setFormatter(new SCLogFormatter());
            fh.setEncoding("UTF-8");
            sinocraftLogger.addHandler(fh);
        } catch (Exception e) {
            log(Level.WARNING, "Error when open SinoCraft.log ." + e);
            return ;
        }
    }

    public static void info(String message) {
        FMLRelaunchLog.log("sinocraft", Level.INFO, message);
    }

    public static void severe(String message) {
        FMLRelaunchLog.log("sinocraft", Level.SEVERE, message);
    }

    @SCConfigAnnotation(Mold = "load", CategoryName = "debug")
    public static void loadConfig(ConfigCategory confige) {
        Property logLevelProp = confige.get("log.Level");
        try {
            sinocraftLogger.setLevel(Level.parse(logLevelProp.getString()));
        } catch (Exception e) {
            log(Level.WARNING, "Error when set loggerLevel ." + e);
            sinocraftLogger.setLevel(Level.SEVERE);
            logLevelProp = null;
        }
        if (logLevelProp == null) {
            logLevelProp = new Property ("log.Level" , "SEVERE", STRING);
            confige.remove("log.Level");
            confige.put("log.Level", logLevelProp);
        }

        Property logFileProp = confige.get("log.File");
        try {
            if (logFileProp.getBoolean(false)) {
                log("EnableFileLog !");
                EnableFileLog();
            }
        } catch (Exception e) {
            log(Level.WARNING, "Error when get log.File config ." + e);
            logFileProp = null;
        }
        if (logFileProp == null) {
            logFileProp = new Property("log.File", "false", BOOLEAN);
            confige.remove("log.File");
            confige.put("log.File", logFileProp);
        }
    }

    @SCConfigAnnotation(Mold = "save", CategoryName = "debug")
    public static void saveConfig() {
    }

}
