package sinocraft.plants.blocks;

import sinocraft.core.blocks.SCFlower;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 杜鹃
 * @author Liong
 *
 */

public class BlockAzalea extends SCFlower
{
	public BlockAzalea(int Id)
	{
		super(Id);
		
		setUnlocalizedName("Azalea");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockAzalea");
	}
}
