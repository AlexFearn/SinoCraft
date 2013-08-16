package sinocraft.foods.container;

import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
 
public class ContainerCookstove extends Container
{
	private TileEntityCookstove tileentity;
	
	public ContainerCookstove(TileEntityCookstove tileentity, InventoryPlayer inventoryplayer)
	{
		this.tileentity = tileentity;
		
		addSlotToContainer(new Slot(tileentity, 0, 60, 17));
		addSlotToContainer(new Slot(tileentity, 1, 60, 53));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}
}