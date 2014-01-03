package sinocraft.plants.blocks;

import java.util.Random;
import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

/**
 * 姊呰姳鏋\x841锟\xBD7
 * @author Liong
 *
 */

public class BlockPrunusMumeBranch extends Block
{
	public BlockPrunusMumeBranch(int Id)
	{
		super(Id, Material.leaves);
		
		setCreativeTab(SinoCraft.sct);
		setTickRandomly(true);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("PrunusMumeBranch");
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
		
		for (int X = x - 4; X <= x + 4; X++)
			for (int Z = z - 4; Z <= z + 4; Z++)
				if (world.getBlockId(X, y, Z) == SCBlocks.blockPrunusMumeWood.blockID)
					return;
		if (noWood)
	        world.setBlockToAir(x, y, z);
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
		blockIcon = i.registerIcon("sinocraft:prunus_mume_branch");
	}
}