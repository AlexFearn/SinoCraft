package SinoCraft.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockPrunusMumeBranch extends Block
{
	public BlockPrunusMumeBranch(int Id)
	{
		super(Id, Material.leaves);
		
		setCreativeTab(CreativeTabs.tabDecorations);
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
	public void updateTick(World world, int x, int z, int y,
			Random random)
	{
		boolean noWood;
		
		for (int i1 = x - 4; i1 <= 9; i1++)
			for (int i2 = z - 4; i2 <= 9; i2++)
				if (world.getBlockId(x, y, z) == wood.blockID);
					noWood = false;
		if (noWood = false)
			world.destroyBlock(x, y, z, false);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockPrunusMumeBranch");
	}
}