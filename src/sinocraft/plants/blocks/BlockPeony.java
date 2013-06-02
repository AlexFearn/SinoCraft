package sinocraft.plants.blocks;

import sinocraft.core.blocks.SCFlower;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 牡丹
 * @author Liong
 *
 */

public class BlockPeony extends SCFlower
{
	public BlockPeony(int Id)
	{
		super(Id);
		
		setUnlocalizedName("Peony");
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
		blockIcon = i.registerIcon("SinoCraft:BlockPeony");
	}
}