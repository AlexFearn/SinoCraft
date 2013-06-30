package sinocraft.plants.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 白菜
 * @author Liong
 *
 */

public class ItemBenincasaPruriens extends Item
{
	public ItemBenincasaPruriens(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Benincasa Pruriens");
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityPlayer)
	{
        if (!entityPlayer.capabilities.isCreativeMode)
        	itemstack.stackSize--;
		entityPlayer.getFoodStats().addStats(2, 0.0F);
        world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		return itemstack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 64;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.eat;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,	EntityPlayer entityPlayer)
	{
        entityPlayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
        return itemstack;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemBenincasaPruriens");
	}
}
