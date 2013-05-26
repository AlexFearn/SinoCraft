package sinocraft;

import sinocraft.proxy.ServerProxy;
import sinocraft.register.SCBlocks;
import sinocraft.register.SCConfig;
import sinocraft.register.SCItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "SinoCraft", name = "SinoCraft", version = "1.0.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class SinoCraft
{
	
	public static SCConfig config;
	
	@Instance("SinoCraft")
	public static SinoCraft instance;
	
	@SidedProxy(clientSide = "SinoCraft.proxy.ClientProxy", serverSide = "SinoCraft.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		config=new SCConfig(event.getSuggestedConfigurationFile());
		
		
		proxy.preLoad(event);
	}
	
	@Init
	public void init(FMLInitializationEvent e)
	{
	
		SCBlocks.load(config);
		SCItems.load(config);
		
		proxy.load(e);
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		config.SaveConfig();
	}
}
