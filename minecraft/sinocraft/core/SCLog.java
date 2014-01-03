package sinocraft.core;

import java.lang.Object;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Property;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

import static net.minecraftforge.common.Property.Type.BOOLEAN;
import static net.minecraftforge.common.Property.Type.DOUBLE;
import static net.minecraftforge.common.Property.Type.INTEGER;
import static net.minecraftforge.common.Property.Type.STRING;


public class SCLog {

    public static Logger SinoCraftLogger = FMLRelaunchLog.log.getLogger().getLogger("SinoCraft");
    public static ConfigCategory DebugConfig;

    public static void log(String format, Object... date) {
        log("INFO", format, date);
    }

    public static void log(String levelstring, String format, Object... date) {
        Level grade = Level.parse(levelstring);
        log(grade, format, date);
    }

    public static void log(Level grade, String format, Object... date) {
        SinoCraftLogger.log(grade, format, date);
    }

    public static void setLevel(Level newlevel) {
        SinoCraftLogger.setLevel(newlevel);
    }

    public static void EnableFileLog() {
        try {
            FileHandler fh = new FileHandler("SinoCraft.log");
            fh.setFormatter(new SCLogFormatter());
            fh.setEncoding("UTF-8");
            SinoCraftLogger.addHandler(fh);
        } catch (Exception e) {
            log(Level.WARNING, "Error when open SinoCraft.log ." + e);
            return ;
        }
    }

    public static void info(String message) {
        FMLRelaunchLog.log("SinoCraft", Level.INFO, message);
    }

    public static void severe(String message) {
        FMLRelaunchLog.log("SinoCraft", Level.SEVERE, message);
    }

    @SCConfigAnnotation(Mold = "laod",CategoryName = "debug")
    public static void laodConfig(ConfigCategory confige) {
        
    }

    @SCConfigAnnotation(Mold = "save",CategoryName = "debug")
    public static void saveConfig() {
    }

}
