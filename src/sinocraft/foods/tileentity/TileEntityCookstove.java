package sinocraft.foods.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import sinocraft.core.register.SCItems;
import sinocraft.foods.blocks.BlockCookstove;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;

/**
 * 炉子的实体
 * @author Liong
 *
 */

public class TileEntityCookstove extends TileEntity implements ISidedInventory
{
	ItemStack[] cookstoveItemStack = new ItemStack[2];
	boolean isBurning; //是否在燃烧
	public int time_CookstoveCanBurn = 0; //炉子可燃烧的时间
	public int time_ItemCankeepCookstoveBurning = 0; //物品可维持炉子燃烧的时间	
	/**
	 * 获取物品槽数量
	 * @return 物品槽数量
	 */
    public int getSizeInventory()
    {
        return cookstoveItemStack.length;
    }
    
    public boolean isBurning()
    {
    	return time_CookstoveCanBurn > 0;
    }
    
    @Override
    public void updateEntity()
    {
    	boolean canBurn = time_CookstoveCanBurn > 0;
    	boolean flag = false;
    	
    	if (time_CookstoveCanBurn > 0)
    		--time_CookstoveCanBurn;
    	if (!worldObj.isRemote)
    	{
    		time_ItemCankeepCookstoveBurning = time_CookstoveCanBurn = getItemBurnTime(cookstoveItemStack[1]);

    		if (time_ItemCankeepCookstoveBurning == 0 && canBurn)
    			if (time_CookstoveCanBurn > 0)
    			{
    				flag = true;
    				if (cookstoveItemStack[1] != null)
    				{
    					--cookstoveItemStack[1].stackSize;
                        if (cookstoveItemStack[1].stackSize == 0)
                            cookstoveItemStack[1] = cookstoveItemStack[1].getItem().getContainerItemStack(cookstoveItemStack[1]);
    				}
    			}
            if (canBurn != time_CookstoveCanBurn > 0)
            {
                flag = true;
                BlockCookstove.updateFurnaceBlockState(time_CookstoveCanBurn > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
    	}
        if (flag)
        {
            onInventoryChanged();
        }
    }
    
    /**
     * 按比例计算出当前剩余可燃烧时间的近似值
     * 显示GUI时调用
     */
    public int getBurnTimeRemainingScaled(int scale)
    {
        if (time_ItemCankeepCookstoveBurning == 0)
        {
            time_ItemCankeepCookstoveBurning = 200;
        }

        return time_CookstoveCanBurn * scale / time_ItemCankeepCookstoveBurning;
    }
    
    public static int getItemBurnTime(ItemStack itemstack)
    {
        if (itemstack == null)
        {
            return 0;
        }
        else
        {
            int i = itemstack.getItem().itemID;
            Item item = itemstack.getItem();

            if (itemstack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
            {
                Block block = Block.blocksList[i];

                if (block == Block.woodSingleSlab)
                	return 150;
                if (block.blockMaterial == Material.wood)
                    return 300;
            }

            if (i == Item.stick.itemID) return 100;
            if (i == Item.coal.itemID) return 1600;
            if (i == Item.blazeRod.itemID) return 2400;
        }
        return 0;
    }
    
    //接口ISidedInventory提供的方法
    
	@Override
	public ItemStack getStackInSlot(int slotID)
	{
		return cookstoveItemStack[slotID];
	}
	
	@Override
	public ItemStack decrStackSize(int slotID, int amount)
	{
    	if (cookstoveItemStack[slotID] != null)	
    	{
	    	ItemStack itemstack;
	    	if (cookstoveItemStack[slotID].stackSize <= amount)
	    	{
	    		itemstack = cookstoveItemStack[slotID];
	    		cookstoveItemStack[slotID] = null;
	    	}
	    	else
	    	{
	    		itemstack = cookstoveItemStack[slotID].splitStack(amount);
	    		if (cookstoveItemStack[slotID].stackSize == 0)
	    			cookstoveItemStack[slotID] = null;
	    		return itemstack;
	    	}
    	}
    	else
			return null;
    	
    	return cookstoveItemStack[slotID];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotID)
	{
    	if (cookstoveItemStack[slotID] != null)
    	{
    		ItemStack itemstack = cookstoveItemStack[slotID];
    		cookstoveItemStack[slotID] = null;
    		return itemstack;
    	}
    	else
    		return null;
	}

	@Override
	public void setInventorySlotContents(int slotID, ItemStack itemstack)
	{
        this.cookstoveItemStack[slotID] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
            itemstack.stackSize = this.getInventoryStackLimit();
	}

	@Override
	public String getInvName()
	{
		return "container.cookstove";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		// TODO 语言文件弄好后记得改成true
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		// TODO 抽时间弄懂这是干啥的
		return true;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isStackValidForSlot(int slotID, ItemStack itemstack)
	{
        return getItemBurnTime(itemstack) > 0 ? true : false;
	}
	
	//下面都是漏斗用的，咱们社会主义用不着
	
	@Override
	public int[] getAccessibleSlotsFromSide(int slotID)
	{
		return null;
	}
	
	@Override
	public boolean canInsertItem(int slotID, ItemStack itemstack, int side)
	{
		return isStackValidForSlot(slotID, itemstack);
	}
	
	@Override
	public boolean canExtractItem(int slotID, ItemStack itemstack, int side)
	{
		return false;
	}
}