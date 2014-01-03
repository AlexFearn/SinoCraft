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
 * 鍐摐
 * @author Liong
 *
 */

public class BlockWinterMelon extends SCCrop
{
	public BlockWinterMelon(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("BenincasaPruriens");
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
		return SCItems.ItemBenincasaPruriens.itemID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_0 = i.registerIcon("sinocraft:BlockWinterMelon_0");
		blockIcon_1 = i.registerIcon("sinocraft:BlockWinterMelon_1");
		blockIcon_2 = i.registerIcon("sinocraft:BlockWinterMelon_2");
		blockIcon_3 = i.registerIcon("sinocraft:BlockWinterMelon_3");
	}
}
