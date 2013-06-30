package sinocraft.plants.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sinocraft.blocks.SCCrop;
import sinocraft.core.register.SCItems;

/**
 * 糯稻
 * @author Liong
 *
 */

public class BlockGlutinousRice extends SCCrop
{
	public BlockGlutinousRice(int Id)
	{
		super(Id);
		
		setUnlocalizedName("Glutinous Rice");
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
