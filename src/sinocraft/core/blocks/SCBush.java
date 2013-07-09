package sinocraft.core.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import sinocraft.core.register.SCRenderer;

public abstract class SCBush extends SCFlower
{
	protected Icon blockIcon_Top;
	protected Icon blockIcon_Branch;
	protected Icon blockIcon_Leaves;
	
	public SCBush(int Id)
	{
		super(Id);
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
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		switch (side)
		{
		case 1:
			return blockIcon_Top;
		case 6:
			return blockIcon_Branch;
		default:
			return blockIcon_Leaves;
		}
	}
	
	@Override
	public int getRenderType()
	{
		return SCRenderer.RendererBushID;
	}
}
