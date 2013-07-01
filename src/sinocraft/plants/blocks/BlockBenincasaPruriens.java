package sinocraft.plants.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
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
		setUnlocalizedName("Benincasa Pruriens");
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!canBlockStay(world, x, y, z))
			world.destroyBlock(x, y, z, true);
		if (world.getBlockMetadata(x, y, z) != 3)
			if (random.nextInt(1024) <= 16)
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
	}
	
	@Override
	public int idDropped(int metadata, Random random, int par3)
	{
		return SCItems.itemBenincasaPruriens.itemID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_0 = i.registerIcon("SinoCraft:BlockBenincasaPruriens_0");
		blockIcon_1 = i.registerIcon("SinoCraft:BlockBenincasaPruriens_1");
		blockIcon_2 = i.registerIcon("SinoCraft:BlockBenincasaPruriens_2");
		blockIcon_3 = i.registerIcon("SinoCraft:BlockBenincasaPruriens_3");
	}
}
