package sinocraft;

import sinocraft.core.SCLog;
import sinocraft.core.SCLoader;
import sinocraft.core.Control.*;
import sinocraft.core.SCLangRegister;

import java.lang.ClassLoader;
import java.net.URLClassLoader;
// import java.lang.Package;
import java.util.Enumeration;
import java.net.URL;
import java.util.zip.*;
import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
// import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.common.ModMetadata;
import java.lang.annotation.Annotation;


@Mod(modid = "SinoCraft", name = "SinoCraft", version = "1.0.0.0 dev")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
/**
 * MOD
 * @author HopeAsd, Liong
 */
public class SinoCraft {
    // public static SCConfig config;
    // public static Configuration config2 ;

    public static final String VERSION = "1.0.0.0 dev";

    // public static CreativeTabs sct = new SCCreativeTab("CC");

    @Instance("SinoCraft")
    public static SinoCraft instance;

    // @SidedProxy(clientSide = "sinocraft.core.proxy.ClientProxy", serverSide = "sinocraft.core.proxy.ServerProxy")
    // public static ServerProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // config = new SCConfig(event.getSuggestedConfigurationFile());
        // SCLog.EnableFileLog();
        // SCLog.log("INFO","h!");
        // Class.forName("sinocraft.SCLog");
        SCConfigControl.load(event.getSuggestedConfigurationFile());
        // ModMetadata mmd = event.getModMetadata();
        SCLog.log("hello!");
        SCLangRegister.load();
        try {
            SCLoader.load(event.getSourceFile());
        } catch (Exception e) {
            SCLog.log("WARNING", "Error ");
            // return;
        }
        SCBlockControl.loadClass();
        //     File f = event.getSourceFile();
        //     URL url = f.toURI().toURL();
        //     SCLog.log("" + url);
        //     String [] stlist;
        //     if (f.isDirectory()) {
        //         stlist = f.list();
        //         for (String st : stlist) {
        //             SCLog.log(st);
        //         }
        //     } else {
        //         ZipFile zf = new ZipFile(f);
        //         Enumeration<?> en = zf.entries();
        //         while (en.hasMoreElements()) {
        //             SCLog.log("" + en.nextElement());
        //         }
        //     }

        //     ClassLoader cl = new URLClassLoader(new URL[] {url} );
        //     url = cl.getSystemResource("SinoCraft");
        //     SCLog.log("" + url);
        // SCLog.log(""+ event.getModConfigurationDirectory());
        // SCLog.log(""+ event.getSuggestedConfigurationFile());
        // SCLog.log(""+ event.getModState());
        // SCLog.log(""+ mmd.getAuthorList());
        // SCLog.log(""+ mmd.printableSortingRules());
        // SCLog.log(""+ mmd.url);


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
        //  SCLog.log("INFO",s);
        // }
        // SCLog.log("INFO",SCLog.sinocraftLogger.getName());
        // proxy.preLoad(event);
        // SCItems.load(config);
        // SCLog.info("No bug at preinit 1");
        // SCBlocks.load(config);
        // SCLog.info("No bug at preinit 2");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // SCLog.info("No bug at init 1");
        // SCCraftingRecipes.load();
        // SCFurnaceRecipes.load();
        // SCProperty.loadProps(config);
        // SCLog.info("No bug at init 2");
        // proxy.load(event);
        // SCLog.info("No bug at init 3");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // config.SaveConfig();
        // proxy.postLoad(event);
    }
}
