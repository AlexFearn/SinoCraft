package sinocraft.core;

import java.util.logging.Level;
import java.lang.Object;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class SCLog{

	public static Logger SinoCraftLogger = FMLRelaunchLog.log.getLogger().getLogger("SinoCraft");

	public static void log(String levelstring, String format,Object... date)
	{
		Level grade = Level.parse(levelstring);
		log(grade,format,date);
	}

	public static void log(Level grade,String format, Object... date)
	{
		SinoCraftLogger.log(grade, format, date);
	}

	public static void setLevel(Level newlevel)
	{
		SinoCraftLogger.setLevel(newlevel);
	}

	public static void EnableFileLog()
	{
	try{
			FileHandler fh = new FileHandler("SinoCraft.log");
			fh.setFormatter(new SCLogFormatter());
			fh.setEncoding("UTF-8");
			SinoCraftLogger.addHandler(fh);
		}catch (Exception e) {
		}
	}

	public static void info(String message)
    {
        FMLRelaunchLog.log("SinoCraft", Level.INFO, message);
    }

    public static void severe(String message)
    {
        FMLRelaunchLog.log("SinoCraft", Level.SEVERE, message);
    }
}
