package sinocraft.core.proxy;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy
{	
	
	@Override
	public void preLoad(FMLPreInitializationEvent event)
	{
		super.preLoad(event);
	}
	
	@Override
	public void load(FMLInitializationEvent event)
	{
		SCRenderer.load(SinoCraft.config);
		super.load(event);
	}
	
	@Override
	public void postLoad(FMLPostInitializationEvent event)
	{
		super.postLoad(event);
	}
}
