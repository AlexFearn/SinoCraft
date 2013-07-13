package sinocraft.foods.blocks;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockWolk extends Block
{
	protected Icon blockIcon_Side;
	protected Icon blockIcon_Handle;
	protected Icon blockIcon_Bottom;
	
	public BlockWolk(int Id)
	{
		super(Id, Material.iron);
		
		setStepSound(soundMetalFootstep);
		setUnlocalizedName("Wolk");
		setCreativeTab(SinoCraft.sct);
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.6F, 0.9375F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		switch (side)
		{
		case 0:
			return blockIcon_Bottom;
		case 6:
			return blockIcon_Handle;
		default:
			return blockIcon_Side;
		}
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
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int x, int y, int z, int side)
	{
		if(side == 1)
			return false;
		return true;
	}
	
	@Override
	public int getRenderType()
	{
		return SCRenderer.RendererWolkID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Side = i.registerIcon("SinoCraft:BlockWolk_Side");
		blockIcon_Bottom = i.registerIcon("SinoCraft:BlockWolk_Bottom");
		blockIcon_Handle = i.registerIcon("SinoCraft:BlockWolk_Handle");
	}
}
