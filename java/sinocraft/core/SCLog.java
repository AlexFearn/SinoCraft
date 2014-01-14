package sinocraft.core;

import java.lang.Object;

import cpw.mods.fml.relauncher.FMLRelaunchLog;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SCLog {

    private static boolean configured;
    private static Logger SCLogger;

    public static void setLogger(Logger... logger) {
        if (logger.length == 0) {
            SCLogger = LogManager.getLogger("sinocraft.SinoCraft");
        } else {
            SCLogger = logger[0];
        }
        configured = true;
    }

    public static void log(String format , Object... data) {
        log(Level.INFO, format, data);
    }

    public static void log(String level, String format, Object... data) {
        log(Level.toLevel(level, Level.INFO), format, data);
    }

    public static void log(Level level, String format, Object... data) {
        if (!configured) {
            setLogger();
        }
        SCLogger.log(level, String.format(format, data));
    }

    public static void log(Throwable ex, String format , Object... data) {
        log(ex, Level.INFO, format, data);
    }

    public static void log(String level, Throwable ex,  String format, Object... data) {
        log(Level.toLevel(level, Level.INFO), ex, format, data);
    }

    public static void log(Level level, Throwable ex, String format, Object... data) {
        if (!configured) {
            setLogger();
        }
        SCLogger.log(level, String.format(format, data), ex);
    }

    public static void info(String format , Object... data) {
        log(format, data);
    }

    public static void severe(String format , Object... data) {
        log(Level.SEVERE, format, data);
    }

}
