package sinocraft.plants.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sinocraft.SinoCraft;
import sinocraft.core.blocks.SCCrop;
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
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("GlutinousRice");
		func_111022_d("sinocraft:BlockGlutinousRice_0");
		func_111022_d("sinocraft:BlockGlutinousRice_1");
		func_111022_d("sinocraft:BlockGlutinousRice_2");
		func_111022_d("sinocraft:BlockGlutinousRice_3");
		func_111022_d("sinocraft:BlockGlutinousRice_4");
		func_111022_d("sinocraft:BlockGlutinousRice_5");
		func_111022_d("sinocraft:BlockGlutinousRice_6");
		func_111022_d("sinocraft:BlockGlutinousRice_7");
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
}
