package sinocraft.plants.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import sinocraft.SinoCraft;
import sinocraft.core.blocks.SCCrop;
import sinocraft.core.register.SCBlocks;
import sinocraft.core.register.SCItems;

/**
 * 白菜
 * @author Liong
 *
 */

public class BlockBenincasaPruriens extends SCCrop
{
	public BlockBenincasaPruriens(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("BenincasaPruriens");
		func_111022_d("sinocraft:BlockBenincasaPruriens_0");
		func_111022_d("sinocraft:BlockBenincasaPruriens_1");
		func_111022_d("sinocraft:BlockBenincasaPruriens_2");
		func_111022_d("sinocraft:BlockBenincasaPruriens_3");
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!canBlockStay(world, x, y, z))
			world.destroyBlock(x, y, z, true);
		if (world.getBlockMetadata(x, y, z) != 3)
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
	}
	
	@Override
	public int idDropped(int metadata, Random random, int par3)
	{
		return SCItems.itemBenincasaPruriens.itemID;
	}
}
