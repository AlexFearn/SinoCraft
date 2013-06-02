package sinocraft.core.register;

import org.omg.CORBA.PUBLIC_MEMBER;

import scala.annotation.StaticAnnotation;
import sinocraft.SinoCraft;
import sinocraft.plants.blocks.BlockAzalea;
import sinocraft.plants.blocks.BlockChrysanthemum;
import sinocraft.plants.blocks.BlockPeony;
import sinocraft.plants.blocks.BlockPrunusMumeBranch;
import sinocraft.plants.blocks.BlockPrunusMumeWood;
import sinocraft.plants.blocks.BlockReed;
import cpw.mods.fml.common.registry.LanguageRegistry;
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

	public static void load(SCConfig config)
	{
		try
		{
			blockPeony = new BlockPeony(config.getBlockID("blockPeony", 501));
			blockChrysanthemum = new BlockChrysanthemum(config.getBlockID("blockChrysanthemum",502));
			blockPrunusMumeBranch = new BlockPrunusMumeBranch(config.getBlockID("blockPrunusMumeBranch",503));
			blockReed = new BlockReed (config.getBlockID("blockReed",504));
			blockAzalea = new BlockAzalea(config.getBlockID("blockAzalea", 505));
			blockPrunusMumeWood = new BlockPrunusMumeWood(config.getBlockID("blockPrunusMumeWood", 506));
		}
		catch (Exception e)
		{
			SinoCraft.log.warning("Error when loading blockIDs from config . " + e);
		}
		/*
		blockPeony = new BlockPeony(501);
		blockChrysanthemum = new BlockChrysanthemum(502);
		blockPrunusMumeBranch = new BlockPrunusMumeBranch(503);
		blockReed = new BlockReed(504);
		blockAzalea = new BlockAzalea(505);
		blockPrunusMumeWood = new BlockPrunusMumeWood(506);
		*/
		ModLoader.registerBlock(blockPeony);
		ModLoader.registerBlock(blockChrysanthemum);
		ModLoader.registerBlock(blockPrunusMumeBranch);
		ModLoader.registerBlock(blockReed);
		ModLoader.registerBlock(blockAzalea);
		ModLoader.registerBlock(blockPrunusMumeWood);
		
		ModLoader.addName(blockPeony, "zh_CN", "牡丹");
		ModLoader.addName(blockChrysanthemum, "zh_CN", "菊花");
		ModLoader.addName(blockPrunusMumeBranch, "zh_CN", "梅花枝");
		ModLoader.addName(blockReed, "zh_CN", "芦苇");
		ModLoader.addName(blockAzalea, "zh_CN", "杜鹃");
		ModLoader.addName(blockPrunusMumeWood, "zh_CN", "梅花木");
		
		ModLoader.addName(blockPeony, "en_US", "Peony");
		ModLoader.addName(blockChrysanthemum, "en_US", "Chrysanthemum");
		ModLoader.addName(blockPrunusMumeBranch, "en_US", "Prunus Mume Branch");
		ModLoader.addName(blockReed, "en_US", "Reed");
		ModLoader.addName(blockAzalea, "en_US", "Azalea");
		ModLoader.addName(blockPrunusMumeWood,"en_US", "Prunus Mume Wood");
		
		return;
	}
}
