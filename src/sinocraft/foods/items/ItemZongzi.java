package sinocraft.foods.items;

import java.util.Random;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * 粽子
 * @author Liong
 *
 */

public class ItemZongzi extends ItemFood
{
	public ItemZongzi(int Id)
	{
		super(Id, 8, 0.8F, false);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Zongzi");
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		super.onEaten(itemstack, world, entityplayer);
		return itemstack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 64;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemZongzi");
	}
}
