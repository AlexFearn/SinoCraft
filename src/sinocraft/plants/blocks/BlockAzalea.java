package sinocraft.plants.blocks;

import sinocraft.SinoCraft;
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
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Azalea");
		func_111022_d("sinocraft:BlockAzalea");
	}
}
