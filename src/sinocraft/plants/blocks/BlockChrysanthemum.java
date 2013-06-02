package sinocraft.plants.blocks;

import sinocraft.core.blocks.SCFlower;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 菊花
 * @author Liong
 *
 */

public class BlockChrysanthemum extends SCFlower
{
	public BlockChrysanthemum(int Id)
	{
		super(Id);
		
		setUnlocalizedName("Chrysanthemum");
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockChrysanthemum"); 
	}
}