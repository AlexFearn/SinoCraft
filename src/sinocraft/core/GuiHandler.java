package sinocraft.core;

import sinocraft.core.register.SCBlocks;
import sinocraft.foods.container.ContainerCookstove;
import sinocraft.foods.gui.GuiCookstove;
import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z)
	{
		if (ID == 0)
		{
			TileEntity tileentity = world.getBlockTileEntity(x, y, z);
			if (tileentity == null || !(tileentity instanceof TileEntityCookstove))
				return null;
			return new ContainerCookstove((TileEntityCookstove)tileentity, player.inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z)
	{
		if (ID == 0)
		{
			TileEntity tileentity = world.getBlockTileEntity(x, y, z);
			if (tileentity == null || !(tileentity instanceof TileEntityCookstove))
				return null;
			return new GuiCookstove((TileEntityCookstove)tileentity, player.inventory);
		}
		return null;
	}
}
