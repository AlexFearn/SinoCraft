package sinocraft;
import net.minecraft.creativetab.CreativeTabs;
import sinocraft.core.SCCreativeTab;
import sinocraft.core.SCLog;
import sinocraft.core.SCWorldGenerator;
import sinocraft.core.proxy.ServerProxy;
import sinocraft.core.register.SCBlocks;
import sinocraft.core.register.SCConfig;
import sinocraft.core.register.SCCraftingRecipes;
import sinocraft.core.register.SCFurnaceRecipes;
import sinocraft.core.register.SCItems;
import sinocraft.core.register.SCProperty;
import sinocraft.core.SCConfigControl;
import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import  java.lang.annotation.Annotation;

import java.lang.reflect.Array;
import java.lang.Package;

@Mod(modid = "SinoCraft", name = "SinoCraft", version = "1.0.0.0 dev")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
/** 
 * MOD
 * @author HopeAsd, Liong
 */
public class SinoCraft
{
	public static SCConfig config;
	public static Configuration config2 ;
	
	public static final String VERSION = "1.0.0.0 dev";
	
	public static CreativeTabs sct = new SCCreativeTab("CC");

	@Instance("SinoCraft")
	public static SinoCraft instance;

	@SidedProxy(clientSide = "sinocraft.core.proxy.ClientProxy", serverSide = "sinocraft.core.proxy.ServerProxy")
	public static ServerProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		config = new SCConfig(event.getSuggestedConfigurationFile());

		SCLog.EnableFileLog();
		SCLog.log("INFO","hello!");
		SCConfigControl.load(event.getSuggestedConfigurationFile());
		SCConfigControl.save();
		// Package pa = Package.getPackage("sinocraft");
		// SCLog.log(pa.getImplementationTitle());
		// SCLog.log(System.getProperty("java.class.path"));
		// for (Annotation p: Package.getPackage("sinocraft"))
		// {
			// SCLog.log("INFO",""+p);
		// }
		// SCLog.log("INFO",""+(FMLRelaunchLog.log.getLogger().getHandlers()[0]).getClass());
		// // SCLog.log("INFO",System.getProperty("user.dir"));
		// for (String s:config2.getCategoryNames()) {
		// 	SCLog.log("INFO",s);
		// }
		// SCLog.log("INFO",SCLog.SinoCraftLogger.getName());
		// proxy.preLoad(event);
		// SCItems.load(config);
		// SCLog.info("No bug at preinit 1");
		// SCBlocks.load(config);
		// SCLog.info("No bug at preinit 2");
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// SCLog.info("No bug at init 1");
		// SCCraftingRecipes.load();
		// SCFurnaceRecipes.load();
		// SCProperty.loadProps(config);
		// SCLog.info("No bug at init 2");
		// proxy.load(event);
		// SCLog.info("No bug at init 3");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// config.SaveConfig();
		// proxy.postLoad(event);
	}
}
