package sinocraft.plants.blocks;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

/**
 * 梅花木
 * @author Liong
 *
 */

public class BlockPrunusMumeWood extends Block
{
	protected Icon[] blockIcon;
			
	public BlockPrunusMumeWood(int Id)
	{
		super(Id, Material.wood);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName("Prunus Mume Wood");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(side == 0||side == 1)
			return blockIcon[1];
		else
			return blockIcon[0];
	}

	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}
	
	@Override
	public int getRenderType()
	{
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon[0] = i.registerIcon("SinoCraft:BlockPrunusMumeWood_Side");
		blockIcon[1] = i.registerIcon("SinoCraft:BlockPrunusMumeWood_UpDown");
	}
}
