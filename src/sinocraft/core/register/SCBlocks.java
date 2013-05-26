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
public class SCBlocks {
	public static Block blockPeony, blockChrysanthemum, blockPrunusMumeBranch,
			blockReed;

	public static void load(SCConfig conf) {
		try {
			blockPeony = new BlockPeony(conf.getBlockID("blockPeony", 501));
			blockChrysanthemum = new BlockChrysanthemum(conf.getBlockID("blockChrysanthemum",502));
			blockPrunusMumeBranch = new BlockPrunusMumeBranch(conf.getBlockID("blockPrunusMumeBranch",503));
			blockReed = new BlockReed (conf.getBlockID("blockReed",504));
			

		} catch (Exception e) {
			SinoCraft.log.warning("Error when loading blockIDs from config . " + e);
		}
		
		ModLoader.registerBlock(blockPeony);
		ModLoader.registerBlock(blockChrysanthemum);
		ModLoader.registerBlock(blockPrunusMumeBranch);
		ModLoader.registerBlock(blockReed);
		
		
		LanguageRegistry.instance().addNameForObject(blockPeony,
				"zh_CN", "牡丹");
		LanguageRegistry.instance().addNameForObject(blockChrysanthemum,
				"zh_CN", "菊花");
		LanguageRegistry.instance().addNameForObject(blockPrunusMumeBranch,
				"zh_CN", "梅花枝");
		LanguageRegistry.instance().addNameForObject(blockReed,
				"zh_CN", "芦苇");

		
		LanguageRegistry.instance().addNameForObject(blockPeony,
				"en_US", "Peony");
		LanguageRegistry.instance().addNameForObject(blockChrysanthemum,
				"en_US", "Chrysanthemum");
		LanguageRegistry.instance().addNameForObject(blockPrunusMumeBranch,
				"en_US", "PrunusMumeBranch");
		LanguageRegistry.instance().addNameForObject(blockReed,
				"en_US", "Reed");
		return;
	}
}
