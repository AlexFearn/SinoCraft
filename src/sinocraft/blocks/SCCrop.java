package sinocraft.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sinocraft.blocks.SCFlower;
import sinocraft.core.register.SCBlocks;
import sinocraft.core.register.SCItems;

/**
 * 所有作物的父类
 * @author Liong
 *
 */

public abstract class SCCrop extends SCFlower
{
	protected Icon blockIcon_0;
	protected Icon blockIcon_1;
	protected Icon blockIcon_2;
	protected Icon blockIcon_3;
	protected Icon blockIcon_4;
	protected Icon blockIcon_5;
	protected Icon blockIcon_6;
	protected Icon blockIcon_7;
	
	public SCCrop(int Id)
	{
		super(Id);
		
		setCreativeTab(null);
		setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!canBlockStay(world, x, y, z))
			world.destroyBlock(x, y, z, true);
		if (world.getBlockMetadata(x, y, z) != 7)
			if (random.nextInt(1024) <= 16)
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return canBlockStay(world, x, y, z);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if (world.getBlockId(x, y - 1, z) == tilledField.blockID &&
				(world.getBlockMaterial(x - 1, y - 1, z	  ) == Material.water ||
				world.getBlockMaterial(x + 1, y - 1, z	  ) == Material.water ||
				world.getBlockMaterial(x	, y - 1, z - 1) == Material.water ||
				world.getBlockMaterial(x	, y - 1, z + 1) == Material.water))
			return true;
		else
			return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		switch (metadata)
		{
			case 0:
				return blockIcon_0;
			case 1:
				return blockIcon_1;
			case 2:
				return blockIcon_2;
			case 3:
				return blockIcon_3;
			case 4:
				return blockIcon_4;
			case 5:
				return blockIcon_5;
			case 6:
				return blockIcon_6;
			case 7:
				return blockIcon_7;
			default:
				return blockIcon_7;
		}
	}
}
