package sinocraft.foods.items;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 粽子
 * @author Liong
 *
 */

public class ItemZongzi extends Item
{
	public ItemZongzi(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Zongzi");

	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityPlayer)
	{
        if (!entityPlayer.capabilities.isCreativeMode)
        	--itemstack.stackSize;
		entityPlayer.getFoodStats().addStats(8, 0.0F);
        world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		return itemstack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 64;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.eat;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,	EntityPlayer entityPlayer)
	{
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemZongzi");
	}
}
