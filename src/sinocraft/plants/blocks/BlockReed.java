package sinocraft.plants.blocks;

import java.util.Random;
import sinocraft.core.blocks.SCFlower;
import sinocraft.core.register.SCItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 芦苇
 * @author Liong
 *
 */

public class BlockReed extends SCFlower
{
	public BlockReed(int Id)
	{
		super(Id);
		
		setUnlocalizedName("Reed");
	}

	@Override
	public int idDropped(int par1, Random random, int par3)
	{
		return SCItems.itemReedLeaves.itemID;
	}	
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(3);
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return EnumPlantType.Beach;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockReed");
	}
}
