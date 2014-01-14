package sinocraft;

import sinocraft.core.SCLog;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod(modid = SinoCraft.MODID, version = SinoCraft.VERSION)
public class SinoCraft {

    public static final String MODID = "SinoCraft";
    public static final String VERSION = "0.0.0.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	// SCLog.setLogger(logger);
    	SCLog.log("hello,SinoCraft!");
		// some example code
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.func_149739_a());
    }

}