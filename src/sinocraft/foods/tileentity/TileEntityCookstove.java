package sinocraft.foods.tileentity;

import net.minecraft.block.BlockFurnace;
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
    public int time_FuelCanBurn = 0; //当前燃料能够维持炉子燃烧的时间，对应熔炉的cirretItemBurnTime
	
	private ItemStack[] itemstacks = new ItemStack[10];
	
	private String LocalizedName = "";
	
	@Override
	public void updateEntity()
	{
        boolean CanBurn = time_CanKeepBurn > 0;
        boolean stillCanBurn = false;
		
		super.updateEntity();
		
		if (CanBurn)
			--time_CanKeepBurn;
		if (!worldObj.isRemote)
        {
            if (time_CanKeepBurn == 0)
            {
                time_FuelCanBurn = time_CanKeepBurn = TileEntityFurnace.getItemBurnTime(itemstacks[1]);

                if (time_CanKeepBurn > 0)
                {
                    stillCanBurn = true;

                    if (itemstacks[1] != null)
                    {
                        --itemstacks[1].stackSize;

                        if (itemstacks[1].stackSize == 0)
                        {
                            itemstacks[1] = this.itemstacks[1].getItem().getContainerItemStack(itemstacks[1]);
                        }
                    }
                }
            }

            if (time_CanKeepBurn > 0)
            {
                ++time_CanKeepBurn;

                if (this.time_CanKeepBurn == 200)
                {
                    this.time_CanKeepBurn = 0;
                    stillCanBurn = true;
                }
            }
            else
                this.time_CanKeepBurn = 0;

            if (CanBurn != this.time_CanKeepBurn > 0)
            {
                stillCanBurn = true;
                BlockFurnace.updateFurnaceBlockState(this.time_CanKeepBurn > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (stillCanBurn)
            onInventoryChanged();
            
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
	public boolean isItemValidForSlot(int slotID, ItemStack itemstack)
	{
        return TileEntityFurnace.isItemFuel(itemstack) && itemstack.itemID != Item.bucketLava.itemID;
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