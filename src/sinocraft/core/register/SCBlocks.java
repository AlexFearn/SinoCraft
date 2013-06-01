package sinocraft.core.register;

import sinocraft.SinoCraft;
import sinocraft.plants.blocks.BlockChrysanthemum;
import sinocraft.plants.blocks.BlockPeony;
import sinocraft.plants.blocks.BlockPrunusMumeBranch;
import sinocraft.plants.blocks.BlockReed;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;

/**
 *  注册MOD内所有的基础方块
 * @author HopeAsd
 *
 */

public class SCBlocks
{
	public static void load()
	{
		Block blockPeony = new BlockPeony(501);
		Block blockChrysanthemum = new BlockChrysanthemum(502);
		Block blockPrunusMumeBranch = new BlockPrunusMumeBranch(503);
		Block blockReed = new BlockReed(504);
		/*
		try
		{
			blockPeony = new BlockPeony(conf.getBlockID("blockPeony", 501));
			blockChrysanthemum = new BlockChrysanthemum(conf.getBlockID("blockChrysanthemum",502));
			blockPrunusMumeBranch = new BlockPrunusMumeBranch(conf.getBlockID("blockPrunusMumeBranch",503));
			blockReed = new BlockReed (conf.getBlockID("blockReed",504));
		}
		catch (Exception e)
		{
			SinoCraft.log.warning("Error when loading blockIDs from config . " + e);
		}
		*/
		
		ModLoader.registerBlock(blockPeony);
		ModLoader.registerBlock(blockChrysanthemum);
		ModLoader.registerBlock(blockPrunusMumeBranch);
		ModLoader.registerBlock(blockReed);
		
		ModLoader.addName(blockPeony, "牡丹");
		ModLoader.addName(blockChrysanthemum, "菊花");
		ModLoader.addName(blockPrunusMumeBranch, "梅花枝");
		ModLoader.addName(blockReed, "芦苇");

		return;
	}
}
