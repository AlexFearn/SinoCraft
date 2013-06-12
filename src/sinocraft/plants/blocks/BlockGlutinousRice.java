package sinocraft.plants.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sinocraft.core.blocks.SCFlower;
import sinocraft.core.register.SCBlocks;
import sinocraft.core.register.SCItems;

public class BlockGlutinousRice extends SCFlower
{
	Icon blockIcon_0;
	Icon blockIcon_1;
	Icon blockIcon_2;
	Icon blockIcon_3;
	Icon blockIcon_4;
	Icon blockIcon_5;
	Icon blockIcon_6;
	Icon blockIcon_7;
	
	public BlockGlutinousRice(int Id)
	{
		super(Id);
		
		setCreativeTab(null);
		setUnlocalizedName("Glutinous Rice");
		setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!canBlockStay(world, x, y, z))
			world.destroyBlock(x, y, z, true);
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
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float maxRandom, int maxItem)
	{
		switch (metadata)
		{
			case 7: dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemGlutinousRice, 1, 0)); break;
			default: break;
		}
	}
	
	@Override
	public int idDropped(int metadata, Random random, int par3)
	{
		return SCItems.itemGlutinousRice.itemID;
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_0 = i.registerIcon("SinoCraft:BlockGlutinousRice_0");
		blockIcon_1 = i.registerIcon("SinoCraft:BlockGlutinousRice_1");
		blockIcon_2 = i.registerIcon("SinoCraft:BlockGlutinousRice_2");
		blockIcon_3 = i.registerIcon("SinoCraft:BlockGlutinousRice_3");
		blockIcon_4 = i.registerIcon("SinoCraft:BlockGlutinousRice_4");
		blockIcon_5 = i.registerIcon("SinoCraft:BlockGlutinousRice_5");
		blockIcon_6 = i.registerIcon("SinoCraft:BlockGlutinousRice_6");
		blockIcon_7 = i.registerIcon("SinoCraft:BlockGlutinousRice_7");
	}
}
