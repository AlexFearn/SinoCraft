package sinocraft.core.register;

import sinocraft.SinoCraft;
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
			SinoCraft.log.warning("Error when loading blockIDs from config . " + e);
		}
		
		ModLoader.registerBlock(blockPeony);
		ModLoader.registerBlock(blockChrysanthemum);
		ModLoader.registerBlock(blockPrunusMumeBranch);
		ModLoader.registerBlock(blockReed);
		ModLoader.registerBlock(blockAzalea);
		ModLoader.registerBlock(blockPrunusMumeWood);
		ModLoader.registerBlock(blockBeanBracket);
		ModLoader.registerBlock(blockGlutinousRice);
		
		ModLoader.addName(blockPeony, "zh_CN", "牡丹");
		ModLoader.addName(blockChrysanthemum, "zh_CN", "菊花");
		ModLoader.addName(blockPrunusMumeBranch, "zh_CN", "梅花枝");
		ModLoader.addName(blockReed, "zh_CN", "芦苇");
		ModLoader.addName(blockAzalea, "zh_CN", "杜鹃");
		ModLoader.addName(blockPrunusMumeWood, "zh_CN", "梅花木");
		ModLoader.addName(blockBeanBracket, "zh_CN", "作物架");

		//ModLoader.addName( , "zh_CN", "");
		
		ModLoader.addName(blockPeony, "en_US", "Peony");
		ModLoader.addName(blockChrysanthemum, "en_US", "Chrysanthemum");
		ModLoader.addName(blockPrunusMumeBranch, "en_US", "Prunus Mume Branch");
		ModLoader.addName(blockReed, "en_US", "Reed");
		ModLoader.addName(blockAzalea, "en_US", "Azalea");
		ModLoader.addName(blockPrunusMumeWood,"en_US", "Prunus Mume Wood");
		ModLoader.addName(blockBeanBracket, "en_US", "Bean Bracket");
		
		//ModLoader.addName( , "en_US", "");
		
		return;
	}
}
