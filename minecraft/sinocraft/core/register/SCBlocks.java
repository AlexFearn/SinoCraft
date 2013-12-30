package sinocraft.core.register;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import sinocraft.SinoCraft;
import sinocraft.foods.blocks.BlockCookstove;
import sinocraft.foods.blocks.BlockWolk;
import sinocraft.foods.tileentity.TileEntityCookstove;
import sinocraft.core.GuiHandler;
import sinocraft.core.SCLog;
import sinocraft.core.blocks.SCFlower;
import sinocraft.plants.blocks.BlockAzalea;
import sinocraft.plants.blocks.BlockBeanBracket;
import sinocraft.plants.blocks.BlockChrysanthemum;
import sinocraft.plants.blocks.BlockGlutinousRice;
import sinocraft.plants.blocks.BlockPeony;
import sinocraft.plants.blocks.BlockPrunusMumeBranch;
import sinocraft.plants.blocks.BlockPrunusMumeSapling;
import sinocraft.plants.blocks.BlockPrunusMumeWood;
import sinocraft.plants.blocks.BlockReed;
import sinocraft.plants.blocks.BlockTeaBush;
import sinocraft.renderers.RendererBush;
import sinocraft.renderers.RendererWolk;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * MOD涓殑鍩虹Block娉ㄥ唽绫\x841\xA47
 * @author HopeAsd
 *
 */

public class SCBlocks
{	
	public static Block blockPeony;
	public static Block blockChrysanthemum;
	public static Block blockPrunusMumeBranch;
	public static Block blockReed;
	public static Block blockAzalea;
	
	public static Block blockPrunusMumeWood;
	public static Block blockBeanBracket;
	public static Block blockGlutinousRice;
//	public static Block blockTeaBush;
	public static Block blockPrunusMumeSapling;

	public static Block blockWolk;
//	public static Block blockCookstoveIdle;
	public static Block blockCookstoveActive;
		
	public static int rendererBushID;
	public static int rendererWolkID;
	
	public static void load(SCConfig config)
	{
		try
		{
			blockPeony = new BlockPeony(config.getBlockID("blockPeony", 500));
			LanguageRegistry.addName(blockPeony, "Peony");
			
			blockChrysanthemum = new BlockChrysanthemum(config.getBlockID("blockChrysanthemum",501));
			LanguageRegistry.addName(blockChrysanthemum, "Chrysanthemum");
			
			blockPrunusMumeBranch = new BlockPrunusMumeBranch(config.getBlockID("blockPrunusMumeBranch",502));
			LanguageRegistry.addName(blockPrunusMumeBranch, "PrunusMumeBranch");
			
			blockReed = new BlockReed (config.getBlockID("blockReed",503));
			LanguageRegistry.addName(blockReed, "Reed");
			
			blockAzalea = new BlockAzalea(config.getBlockID("blockAzalea", 504));
			LanguageRegistry.addName(blockAzalea, "Azalea");
			
			blockPrunusMumeWood = new BlockPrunusMumeWood(config.getBlockID("blockPrunusMumeWood", 505));
			LanguageRegistry.addName(blockPrunusMumeWood, "PrunusMumeWood");
			
			blockPrunusMumeSapling = new BlockPrunusMumeSapling(config.getBlockID("blockPrunusMumeSapling", 506));
			LanguageRegistry.addName(blockPrunusMumeSapling, "PrunusMumeSapling");
			
			blockBeanBracket = new BlockBeanBracket(config.getBlockID("blockBeanBracket", 507));
			LanguageRegistry.addName(blockBeanBracket, "BeanBracket");
			
			blockGlutinousRice = new BlockGlutinousRice(config.getBlockID("blockGlutinousRice", 508));
			LanguageRegistry.addName(blockGlutinousRice, "GlutinousRice");
			
//			blockTeaBush = new BlockTeaBush(config.getBlockID("blockTeaBush", 509));
//			LanguageRegistry.addName(blockTeaBush, "TeaBush");
			
			blockWolk = new BlockWolk(config.getBlockID("blockWolk", 510));
			LanguageRegistry.addName(blockWolk, "Wolk");
			
//			blockCookstoveIdle = new BlockCookstove(config.getBlockID("blockCookstoIdle", 511), false);
//			LanguageRegistry.addName(blockCookstoveIdle, "CookstoveIdle");
			
			blockCookstoveActive = new BlockCookstove(config.getBlockID("blockCookstoveActive", 512), true);
			LanguageRegistry.addName(blockCookstoveActive, "Cookstove");
			
			rendererBushID = config.getInteger("rendererBush", 80);
			rendererWolkID = config.getInteger("rendererWolk", 81);

		}
		catch (Exception e)
		{
			SCLog.info("Error when loading blockIDs from config . " + e);
		}
		
		ModLoader.registerBlock(blockPeony);
		ModLoader.registerBlock(blockChrysanthemum);
		ModLoader.registerBlock(blockPrunusMumeBranch);
		ModLoader.registerBlock(blockReed);
		ModLoader.registerBlock(blockAzalea);
		
		ModLoader.registerBlock(blockPrunusMumeWood);
		ModLoader.registerBlock(blockPrunusMumeSapling);
		ModLoader.registerBlock(blockBeanBracket);
		ModLoader.registerBlock(blockGlutinousRice);
//		ModLoader.registerBlock(blockTeaBush);
	
    	ModLoader.registerBlock(blockWolk);
//		ModLoader.registerBlock(blockCookstoveIdle);
		ModLoader.registerBlock(blockCookstoveActive);
		
		ModLoader.registerTileEntity(TileEntityCookstove.class, "TileEntityBlockCookstove");
				
		NetworkRegistry.instance().registerGuiHandler(SinoCraft.instance, new GuiHandler());
		
		RenderingRegistry.registerBlockHandler(rendererBushID, new RendererBush());
		RenderingRegistry.registerBlockHandler(rendererWolkID, new RendererWolk());
		return;
	}
}
