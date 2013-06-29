package sinocraft.core.register;

import sinocraft.core.SCLog;
import sinocraft.plants.blocks.BlockAzalea;
import sinocraft.plants.blocks.BlockBeanBracket;
import sinocraft.plants.blocks.BlockChrysanthemum;
import sinocraft.plants.blocks.BlockGlutinousRice;
import sinocraft.plants.blocks.BlockPeony;
import sinocraft.plants.blocks.BlockPrunusMumeBranch;
import sinocraft.plants.blocks.BlockPrunusMumeWood;
import sinocraft.plants.blocks.BlockReed;
import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;

/**
 * MOD中的基础Block注册类
 * @author HopeAsd
 *
 */

public class SCBlocks
{	
	public static BlockPeony blockPeony;
	public static BlockChrysanthemum blockChrysanthemum;
	public static BlockPrunusMumeBranch blockPrunusMumeBranch;
	public static BlockReed blockReed;
	public static BlockAzalea blockAzalea;
	public static BlockPrunusMumeWood blockPrunusMumeWood;
	public static BlockBeanBracket blockBeanBracket;
	public static BlockGlutinousRice blockGlutinousRice;

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
			blockBeanBracket = new BlockBeanBracket(config.getBlockID("blockBeanBracket", 506));
			blockGlutinousRice = new BlockGlutinousRice(config.getBlockID("blockGlutinousRice", 507));
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
		ModLoader.registerBlock(blockBeanBracket);
		ModLoader.registerBlock(blockGlutinousRice);
		
		return;
	}
}
