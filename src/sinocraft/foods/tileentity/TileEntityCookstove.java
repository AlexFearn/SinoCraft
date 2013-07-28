package sinocraft.foods.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
 
public class TileEntityCookstove extends TileEntity implements IInventory
{
	boolean isActive;
    public int time_CanKeepBurn = 0; //炉子将会持续燃烧的时间，对应熔炉的furnaceBurnTime

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int time_FuelCanBurn = 0; //当前燃料能够维持炉子燃烧的时间，对应熔炉的cirretItemBurnTime
	
	private ItemStack[] itemstacks = new ItemStack[3];
	
	private String LocalizedName = "";
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		
		if ()
	}

	@Override
	public int getSizeInventory()
	{
		return itemstacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotID)
	{
		return itemstacks[slotID];
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
		if (itemstacks[slotID] != null)
		{
			ItemStack itemstack = itemstacks[slotID];
			itemstacks[slotID] = null;
			return itemstack;
		}
		else
			return null;
	}

	@Override
	public void setInventorySlotContents(int slotID, ItemStack itemstack)
	{
        itemstacks[slotID] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
	}

	@Override
	public String getInvName()
	{
		return isInvNameLocalized() ? LocalizedName : "container.cookstove";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return LocalizedName != null && LocalizedName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest()
	{
		
	}

	@Override
	public void closeChest()
	{
		
	}

	@Override
	public boolean isStackValidForSlot(int slotID, ItemStack itemstack)
	{
        return slotID == 2 ? false : (slotID == 1 ? (TileEntityFurnace.isItemFuel(itemstack) && itemstack.itemID != Item.bucketLava.itemID) : true);
	}

	public void LocalizeName(String name)
	{
		LocalizedName = name;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
        super.readFromNBT(nbtTagCompound);
        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items");
        this.itemstacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.itemstacks.length)
            {
                this.itemstacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        time_CanKeepBurn = nbtTagCompound.getShort("BurnTime");
        time_FuelCanBurn = TileEntityFurnace.getItemBurnTime(this.itemstacks[1]);

        if (nbtTagCompound.hasKey("CustomName"))
        {
            this.LocalizedName = nbtTagCompound.getString("CustomName");
        }
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setShort("BurnTime", (short)time_CanKeepBurn);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemstacks.length; ++i)
        {
            if (itemstacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                itemstacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbtTagCompound.setTag("Items", nbttaglist);

        if (this.isInvNameLocalized())
        {
            nbtTagCompound.setString("CustomName", this.LocalizedName);
        }
	}
}