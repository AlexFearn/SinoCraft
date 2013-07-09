package sinocraft.core.register;

import cpw.mods.fml.common.registry.GameRegistry;
import sinocraft.cooker.block.BlockWolk;
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
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;

/**
 * MOD中的基础Block注册类
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
	public static Block blockTeaBush;
	public static Block blockPrunusMumeSapling;
	
	public static BlockWolk blockWolk;

	public static void load(SCConfig config)
	{
		try
		{
			blockPeony = new BlockPeony(config.getBlockID("blockPeony", 500));
			blockChrysanthemum = new BlockChrysanthemum(config.getBlockID("blockChrysanthemum",501));
			blockPrunusMumeBranch = new BlockPrunusMumeBranch(config.getBlockID("blockPrunusMumeBranch",502));
			blockReed = new BlockReed (config.getBlockID("blockReed",503));
			blockAzalea = new BlockAzalea(config.getBlockID("blockAzalea", 504));
			
			blockPrunusMumeWood = new BlockPrunusMumeWood(config.getBlockID("blockPrunusMumeWood", 505));
			blockPrunusMumeSapling = new BlockPrunusMumeSapling(config.getBlockID("blockPrunusMumeSapling", 509));
			blockBeanBracket = new BlockBeanBracket(config.getBlockID("blockBeanBracket", 506));
			blockGlutinousRice = new BlockGlutinousRice(config.getBlockID("blockGlutinousRice", 507));
			blockTeaBush = new BlockTeaBush(config.getBlockID("blockTeaBush", 508));
			
			blockWolk = new BlockWolk(config.getBlockID("blockWolk", 509));
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
		ModLoader.registerBlock(blockTeaBush);
	
		ModLoader.registerBlock(blockWolk);
		
		return;
	}
}
