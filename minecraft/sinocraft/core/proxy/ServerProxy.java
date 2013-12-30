package sinocraft.core.proxy;

import sinocraft.core.SCLog;
import sinocraft.core.SCWorldGenerator;
import sinocraft.core.register.LangRegister;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy
{
	public void preLoad(FMLPreInitializationEvent event)
	{
		
	}
	
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new SCWorldGenerator());
		
		LangRegister.load();
		
		SCLog.info("Proxy Load!");
	}
	
	public void postLoad(FMLPostInitializationEvent event)
	{
		
	}
	
	public static boolean isRendering()
	{
		return !isSimulating();
	}
	private static boolean isSimulating()
	{
		return !FMLCommonHandler.instance().getEffectiveSide().isClient();
	}
	
}
