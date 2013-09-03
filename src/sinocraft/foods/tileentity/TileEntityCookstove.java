package sinocraft.foods.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.foods.blocks.BlockCookstove;
import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
 
public class TileEntityCookstove extends TileEntity implements IInventory
{
	
	boolean isActive;
    public int time_CookstoveCanKeepBurn = 0; //炉子将会持续燃烧的时间，对应熔炉的furnaceBurnTime
    public int time_FuelCanBurn = 0; //当前燃料能够维持炉子燃烧的时间，对应熔炉的currentItemBurnTime
	
	private ItemStack[] itemstacks = new ItemStack[10];
	
	private String LocalizedName = "";
	
	@Override
	public void updateEntity()
	{
        boolean CanBurn = time_CookstoveCanKeepBurn > 0;
        boolean stillCanBurn = false;
				
		if (time_CookstoveCanKeepBurn > 0)
		{
			System.out.println(time_CookstoveCanKeepBurn);
			--time_CookstoveCanKeepBurn;
		}
		if (!worldObj.isRemote)
        {
            if (time_CookstoveCanKeepBurn == 0 && isAbleToBurn())
            {
                time_FuelCanBurn = time_CookstoveCanKeepBurn = TileEntityFurnace.getItemBurnTime(itemstacks[0]);

                if (time_CookstoveCanKeepBurn > 0)
                {
                    stillCanBurn = true;

                    if (itemstacks[0] != null)
                    {
                        --itemstacks[0].stackSize;

                        if (itemstacks[0].stackSize == 0)
                        {
                            itemstacks[0] = null;
                        }
                    }
                }
            }
            
            if (CanBurn != time_CookstoveCanKeepBurn > 0)
            {
                stillCanBurn = true;
                BlockCookstove.updateCookstoveBlockState(time_CookstoveCanKeepBurn > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (stillCanBurn)
            onInventoryChanged();
	}
	
    private boolean isAbleToBurn()
    {
        return itemstacks[0] != null;
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
	public void openChest()	{}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemstack)
	{
        return TileEntityFurnace.isItemFuel(itemstack);
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
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
            byte b = nbttagcompound.getByte("Slot");

            if (b >= 0 && b < this.itemstacks.length)
            {
                this.itemstacks[b] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }

        time_CookstoveCanKeepBurn = nbtTagCompound.getShort("time_CookstoveCanKeepBurn");
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
        nbtTagCompound.setShort("time_CookstoveCanKeepBurn", (short)time_CookstoveCanKeepBurn);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < itemstacks.length; ++i)
        {
            if (itemstacks[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                itemstacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        nbtTagCompound.setTag("Items", nbttaglist);

        if (this.isInvNameLocalized())
        {
            nbtTagCompound.setString("CustomName", this.LocalizedName);
        }
	}
	
    public void setGuiDisplayName(String name)
    {
        LocalizedName = name;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int scale)
    {
    	if (time_FuelCanBurn == 0)
    		time_FuelCanBurn = 200;
        return this.time_CookstoveCanKeepBurn * scale / this.time_FuelCanBurn;
    }
}