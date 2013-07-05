package sinocraft.core;

import java.util.logging.Level;

import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class SCLog {
	public static void info(String message)
    {
        FMLRelaunchLog.log("SinoCraft", Level.INFO, message);
    }

    public static void severe(String message)
    {
        FMLRelaunchLog.log("SinoCraft", Level.SEVERE, message);
    }
}
