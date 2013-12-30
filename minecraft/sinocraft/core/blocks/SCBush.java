package sinocraft.core.blocks;

import sinocraft.core.register.SCBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public abstract class SCBush extends SCFlower
{
	protected Icon blockIcon_Top;
	protected Icon blockIcon_Leaves;
	
	protected Icon blockIcon_Top_Grown;
	protected Icon blockIcon_Leaves_Grown;
	
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
		if (metadata == 1)
			switch (side)
			{
			case 1:
				return blockIcon_Top_Grown;
			case 6:
				return blockIcon;
			default:
				return blockIcon_Leaves_Grown;
			}
		else
			switch (side)
			{
			case 1:
				return blockIcon_Top;
			case 6:
				return blockIcon;
			default:
				return blockIcon_Leaves;
			}
	}
	
	@Override
	public int getRenderType()
	{
		return SCBlocks.rendererBushID;
	}
}