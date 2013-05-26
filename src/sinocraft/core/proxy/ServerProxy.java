package sinocraft.core.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy
{
	public void preLoad(FMLPreInitializationEvent event)
	{
		
	}
	
	public void load(FMLInitializationEvent event)
	{
		
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
