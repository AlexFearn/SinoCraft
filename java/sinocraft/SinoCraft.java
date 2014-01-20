package sinocraft;

import sinocraft.cooks.Cook;
import sinocraft.core.SCLog;
import sinocraft.items.SCItemCookbook;
import sinocraft.items.SCItemCookbookPage;
import net.minecraft.block.BlockWood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.common.registry.GameRegistry;

// import org.apache.logging.log4j.Logger;
// import org.apache.logging.log4j.LogManager;

@Mod(modid = SinoCraft.MODID, version = SinoCraft.VERSION)
public class SinoCraft {

    public static final String MODID = "SinoCraft";
    public static final String VERSION = "0.0.0.0";

    @Instance(SinoCraft.MODID)
    public static SinoCraft instance;


    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        // SCLog.setLogger(logger);
        SCLog.log("hello,SinoCraft!");
        // SCLog.log("%d",BlockWood.field_150096_a.length);
        SCItemCookbook i = new SCItemCookbook();
        new Cook("test1").setColor(0x008800);
        new Cook("test2").setColor(0x880688);
        i.setUnlocalizedName("Cookbook").setCreativeTab(CreativeTabs.tabMisc);
        i.setTextureName("sinocraft:cookbook");
        SCItemCookbookPage p = new SCItemCookbookPage();
        p.setCooklist(Cook.getCooklist()).setUnlocalizedName("CookbookPage").setCreativeTab(CreativeTabs.tabMisc).setTextureName("sinocraft:cookbookpage");
        // SCLog.log(i.getUnlocalizedName());
        // SCLog.log("%d",i.setUnlocalizedName("book").sestCreativeTab(CreativeTabs.tabMisc).setTextureName("book_normal"));)
        GameRegistry.registerItem(i, "Cookbook", SinoCraft.MODID);
        GameRegistry.registerItem(p, "CookbookPage", SinoCraft.MODID);
        // some example code
        // System.out.println("DIRT BLOCK >> "+Blocks.dirt.func_149739_a());
    }

}