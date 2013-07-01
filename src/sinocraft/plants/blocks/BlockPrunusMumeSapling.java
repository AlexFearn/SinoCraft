package sinocraft.plants.blocks;

import java.util.Random;

import sinocraft.core.blocks.SCFlower;
import sinocraft.core.register.SCBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockPrunusMumeSapling extends SCFlower
{
	public BlockPrunusMumeSapling(int Id)
	{
		super(Id);
		setUnlocalizedName("Prunus Mume Sapling");
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(1024) <=16)
		{
			world.setBlock(x    , y    , z    , SCBlocks.blockPrunusMumeWood.blockID);
			world.setBlock(x    , y + 1, z    , SCBlocks.blockPrunusMumeWood.blockID);
			world.setBlock(x    , y + 2, z    , SCBlocks.blockPrunusMumeWood.blockID);
			world.setBlock(x    , y + 3, z    , SCBlocks.blockPrunusMumeWood.blockID);
			world.setBlock(x + 1, y + 2, z    , SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x + 1, y + 3, z    , SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x - 1, y + 2, z    , SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x - 1, y + 3, z    , SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x    , y + 2, z + 1, SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x    , y + 3, z + 1, SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x    , y + 2, z - 1, SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x    , y + 3, z - 1, SCBlocks.blockPrunusMumeBranch.blockID);
			world.setBlock(x    , y + 4, z    , SCBlocks.blockPrunusMumeBranch.blockID);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockPrunusMumeSapling");
	}
}
