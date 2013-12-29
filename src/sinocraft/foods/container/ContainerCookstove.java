package sinocraft.foods.container;

import org.objectweb.asm.tree.IntInsnNode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
 
public class ContainerCookstove extends Container
{
	private TileEntityCookstove tileentity;
	
    public int time_last_CookstoveCanKeepBurn = 0;
    public int time_last_FuelCanBurn = 0;
	
	public ContainerCookstove(TileEntityCookstove tileentity, InventoryPlayer inventoryplayer)
	{
		this.tileentity = tileentity;
		
		bindPlayerInventory(inventoryplayer);
		
		addSlotToContainer(new Slot(tileentity, 0, 116, 35));
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                addSlotToContainer(new Slot(tileentity, i + j * 3 + 1, 8 + i * 18, 17 + j * 18));
            }
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}
	
	/**
	 * 鐢ㄦ潵缁戝畾鐜╁鑳屽寘涓殑鐗╁搧搴\x93
	 * @param inventoryPlayer 鐜╁鑳屽寘涓殑鐗╁搧搴\x93 
	 */
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        for (int i = 0; i < 3; i++)
        {
        	for (int j = 0; j < 9; j++)
        	{
        		addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        
        for (int i = 0; i < 9; i++)
        {
        	addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
		ItemStack itemstack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		
		if (slotObject != null && slotObject.getHasStack())
		{
			ItemStack stackInSlot = slotObject.getStack();
			itemstack = stackInSlot.copy();
			
			if (slot < 9)
			{
				if (!this.mergeItemStack(stackInSlot, 0, 35, true))
						return null;
				else if (!this.mergeItemStack(stackInSlot, 0, 9, false))
					return null;
				
				if (stackInSlot.stackSize == 0)
					slotObject.putStack(null);
				else
					slotObject.onSlotChanged();
				
				if (stackInSlot.stackSize == itemstack.stackSize)
					return null;
				slotObject.onPickupFromSlot(player, stackInSlot);
			}
		}
		return itemstack;
    }
    
    @Override
    public void detectAndSendChanges()
    {
    	super.detectAndSendChanges();
    	
        for (int i = 0; i < this.crafters.size(); ++i)
        {
        	ICrafting iCrafting = (ICrafting) this.crafters.get(i);
        	
        	if (time_last_CookstoveCanKeepBurn != tileentity.time_CookstoveCanKeepBurn)
        		iCrafting.sendProgressBarUpdate(this, 0, tileentity.time_CookstoveCanKeepBurn);
        	if (time_last_FuelCanBurn != tileentity.time_FuelCanBurn)
        		iCrafting.sendProgressBarUpdate(this, 1, tileentity.time_FuelCanBurn);
        }
        
        time_last_CookstoveCanKeepBurn = tileentity.time_CookstoveCanKeepBurn;
        time_last_FuelCanBurn = tileentity.time_FuelCanBurn;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int ID, int value)
    {
    	if (ID == 0)
    		tileentity.time_CookstoveCanKeepBurn = value;
    	if (ID == 1)
    		tileentity.time_FuelCanBurn = value;
    }
}