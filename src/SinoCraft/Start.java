package SinoCraft;

import SinoCraft.items.ItemReedLeaves;
import SinoCraft.proxy.ServerProxy;
import SinoCraft.blocks.plants.BlockChrysanthemum;
import SinoCraft.blocks.plants.BlockPeony;
import SinoCraft.blocks.plants.BlockPrunusMumeBranch;
import SinoCraft.blocks.plants.BlockReed;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;

@Mod(modid = "SinoCraft", name = "SinoCraft", version = "1.0.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Start
{
	@Instance("SinoCraft")
	public static Start instance;
	
	@SidedProxy(clientSide = "SinoCraft.proxy.ClientProxy", serverSide = "SinoCraft.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	@Init
	public void init(FMLInitializationEvent e)
	{
		proxy.Sino();
		
		//Blocks
		
		int BlockPeonyId = 501;
		Block blockPeony = new BlockPeony(BlockPeonyId);
		ModLoader.registerBlock(blockPeony);
		ModLoader.addName(blockPeony, "Äµµ¤");
		
		int BlockChrysanthemumId = 502;
		Block blockChrysanthemum = new BlockChrysanthemum(BlockChrysanthemumId);
		ModLoader.registerBlock(blockChrysanthemum);
		ModLoader.addName(blockChrysanthemum, "¾Õ»¨");
		
		int BlockPrunusMumeBranchId = 503;
		Block blockPrunusMumeBranch = new BlockPrunusMumeBranch(BlockPrunusMumeBranchId);
		ModLoader.registerBlock(blockPrunusMumeBranch);
		ModLoader.addName(blockPrunusMumeBranch, "Ã·»¨Ö¦");

		int BlockReedId = 504;
		Block blockReed = new BlockReed(BlockReedId);
		ModLoader.registerBlock(blockReed);
		ModLoader.addName(blockReed, "Â«Î­");
		
		//Items
		
		int ItemReedLeavesId = 2400;
		Item itemReedLeaves = new ItemReedLeaves(ItemReedLeavesId);
		ModLoader.addName(itemReedLeaves, "ôÕÒ¶");
	}
}
