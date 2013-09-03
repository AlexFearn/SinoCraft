package sinocraft.plants.blocks;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

/**
 * 梅花木
 * @author Liong
 *
 */

public class BlockPrunusMumeWood extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon blockIcon_UpDown;
	@SideOnly(Side.CLIENT)
	private Icon blockIcon_Side;
	
	public BlockPrunusMumeWood(int Id)
	{
		super(Id, Material.wood);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName("PrunusMumeWood");
		func_111022_d("sinocraft:BlockPrunusMumeWood_UpDown");
		func_111022_d("sinocraft:BlockPrunusMumeWood_Side");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess iBlockAccess, int x, int y, int z, int side)
	{
		if(side == 0 || side == 1)
			return blockIcon_UpDown;
		else
			return blockIcon_Side;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(side == 0 || side == 1)
			return blockIcon_UpDown;
		else
			return blockIcon_Side;
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
}
