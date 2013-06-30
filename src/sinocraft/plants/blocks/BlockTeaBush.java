package sinocraft.plants.blocks;

import com.google.common.base.CaseFormat;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.register.SCRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * 茶树
 * @author Liong
 *
 */

public class BlockTeaBush extends Block
{
	protected Icon blockIcon_Branch;
	protected Icon blockIcon_Leaves;
	
	public BlockTeaBush(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("Tea Bush");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		if (side == 0)
			return false;
		return true;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return SCRenderer.RendererTeaBushID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		switch (side)
		{
		case 6:
			return blockIcon_Branch;
		default:
			return blockIcon_Leaves;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Branch = i.registerIcon("BlockTeaBush_Branch");
		blockIcon_Leaves = i.registerIcon("BlockTeaBush_Leaves");
	}
}
