package sinocraft.plants.blocks;

import sinocraft.SinoCraft;
import sinocraft.core.blocks.SCFlower;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 鑿婅姳
 * @author Liong
 *
 */

public class BlockChrysanthemum extends SCFlower
{
	public BlockChrysanthemum(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Chrysanthemum");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("sinocraft:chrysanthemum");
	}
}