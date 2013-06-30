package sinocraft.core.register;

import javax.sql.CommonDataSource;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.RenderingRegistry;
import sinocraft.SinoCraft;
import sinocraft.core.SCLog;
import sinocraft.renderers.RendererTeaBush;

/**
 * MOD中的渲染器注册类
 * @author Liong
 *
 */

public class SCRenderer
{
	public static int RendererTeaBushID;
	
	public static void load(SCConfig config)
	{
		try
		{
			RendererTeaBushID = config.getInteger("rendererTeaBush", 80);
		}
		catch(Exception e)
		{
			SCLog.info("Error when loading renderIDs from config . " + e);
		}
		RenderingRegistry.registerBlockHandler(RendererTeaBushID, new RendererTeaBush());
		
		addSeeds();
	}

	private static void addSeeds()
	{
		MinecraftForge.addGrassPlant(SCBlocks.blockPeony, 0, 2);
		MinecraftForge.addGrassPlant(SCBlocks.blockChrysanthemum, 0, 2);
		MinecraftForge.addGrassPlant(SCBlocks.blockAzalea, 0, 2);
		MinecraftForge.addGrassSeed(new ItemStack(SCItems.itemGlutinousRice), 1);
	}
	
	
}
