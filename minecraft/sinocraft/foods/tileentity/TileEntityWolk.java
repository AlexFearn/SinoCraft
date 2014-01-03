package sinocraft.foods.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWolk extends TileEntity implements IInventory
{
	ItemStack itemstacks[];
	@Override
	public int getSizeInventory()
	{
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int slotID)
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slotID, int amount)
	{
		if (itemstacks[slotID] != null)
        {
            ItemStack itemstack;

            if (itemstacks[slotID].stackSize <= amount)
            {
                itemstack = itemstacks[slotID];
                itemstacks[slotID] = null;
                return itemstack;
            }
            else
            {
                itemstack = itemstacks[slotID].splitStack(amount);

                if (itemstacks[slotID].stackSize == 0)
                    itemstacks[slotID] = null;
                
                return itemstack;
            }
        }
        else
            return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotID)
	{
		ItemStack itemstack = itemstacks[slotID];
		itemstacks[slotID] = null;
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

}
