package sinocraft.foods.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerCookstove extends Container
{
    private TileEntityCookstove cookstove;
    private int last_ItemHasBeenBurned = 0;
    private int last_CookstoveCanBurn = 0;
    private int last_ItemCankeepCookstoveBurning = 0;
    
	public ContainerCookstove(TileEntityCookstove tileentity, InventoryPlayer inventoryplayer)
	{
		addSlotToContainer(new Slot(tileentity, 0, 56, 35));
		addSlotToContainer(new Slot(tileentity, 1, 116, 35));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                addSlotToContainer(new Slot(inventoryplayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return cookstove.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting iCrafting)
	{
		super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, cookstove.time_CookstoveCanBurn);
        iCrafting.sendProgressBarUpdate(this, 1, cookstove.time_ItemCankeepCookstoveBurning);
	}
	
	@Override
	public void detectAndSendChanges()
	{
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)crafters.get(i);
            if (last_CookstoveCanBurn != cookstove.time_CookstoveCanBurn)
                icrafting.sendProgressBarUpdate(this, 0, cookstove.time_CookstoveCanBurn);
            if (last_ItemCankeepCookstoveBurning != cookstove.time_ItemCankeepCookstoveBurning)
                icrafting.sendProgressBarUpdate(this, 1, cookstove.time_ItemCankeepCookstoveBurning);
        }
        
        last_CookstoveCanBurn = cookstove.time_CookstoveCanBurn;
        last_ItemCankeepCookstoveBurning = cookstove.time_ItemCankeepCookstoveBurning;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int ID, int newValue)
	{
		super.updateProgressBar(ID, newValue);
        if (ID == 0)
        {
            cookstove.time_CookstoveCanBurn = newValue;
        }

        if (ID == 1)
        {
            cookstove.time_ItemCankeepCookstoveBurning = newValue;
        }
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityplayer, int slotID)
	{
		ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(slotID);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotID == 1)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                    return null;

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotID != 1 && slotID != 0)
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                        return null;
                }
                else if (TileEntityCookstove.getItemBurnTime(itemstack1) > 0)
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                        return null;
                }
                else if (slotID >= 3 && slotID < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                        return null;
                }
                else if (slotID >= 30 && slotID < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                    return null;
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
                return null;

            if (itemstack1.stackSize == 0)
                slot.putStack((ItemStack)null);
            else
                slot.onSlotChanged();

            if (itemstack1.stackSize == itemstack.stackSize)
                return null;

            slot.onPickupFromSlot(entityplayer, itemstack1);
        }

        return itemstack;
	}
}
