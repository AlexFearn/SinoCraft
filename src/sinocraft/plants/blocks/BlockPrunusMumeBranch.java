package sinocraft.plants.blocks;

import java.util.Random;

import sinocraft.SinoCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockPrunusMumeBranch extends Block
{
	
	public BlockPrunusMumeBranch(int Id)
	{
		super(Id, Material.leaves);
		
		//this.setCreativeTab(SinoCraft.sct);
		setTickRandomly(true);
		this.setUnlocalizedName("prunusmumebranch");
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
	
	
	@SideOnly(Side.SERVER)
	@Override
	public void updateTick(World world, int x, int z, int y, Random random)
	{
		boolean noWood = true;
		int Y = y;
		
		for (int X = x - 4; X <= x + 4; X++)
			for (int Z = z - 4; Z <= z + 4; Z++)
				if (world.getBlockId(X, y, Z) == 3)
					noWood = false;
		if (noWood)
	        world.setBlockToAir(x, z, y);
	}
	
	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockPrunusMumeBranch");
	}
}