package sinocraft.core.blocks;

import java.util.Random;

import sinocraft.SinoCraft;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * SinoCraft所有花的父类
 * @author LIONG
 *
 */

public class SCFlower extends BlockFlower
{
	public SCFlower(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundGrassFootstep);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return canBlockStay(world, x, y, z);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if (world.getBlockId(x, y - 1, z) == grass.blockID ||
			world.getBlockId(x, y - 1, z) == dirt.blockID)
			return true;
		else
			return false;
	}
	
	@Override
	public int getRenderType()
	{
		return 1;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public int idDropped(int metadata, Random random, int par3)
	{
		return this.blockID;
	}
}