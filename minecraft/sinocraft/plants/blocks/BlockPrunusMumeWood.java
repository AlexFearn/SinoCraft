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
 * 姊呰姳鏈\x841锟\xBD7
 * @author Liong
 *
 */

public class BlockPrunusMumeWood extends Block
{
	protected Icon blockIcon_Top;
	
	public BlockPrunusMumeWood(int Id)
	{
		super(Id, Material.wood);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName("PrunusMumeWood");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess iBlockAccess, int x, int y, int z, int side)
	{
		if(side == 0 || side == 1)
			return blockIcon_Top;
		else
			return blockIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		if(side == 0 || side == 1)
			return blockIcon_Top;
		else
			return blockIcon;
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
		blockIcon = i.registerIcon("sinocraft:prunus_mume_wood_side");
		blockIcon_Top = i.registerIcon("sinocraft:prunus_mume_wood_ud");
	}
}
