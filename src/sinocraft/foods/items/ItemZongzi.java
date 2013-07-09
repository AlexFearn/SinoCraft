package sinocraft.foods.items;

import java.util.Random;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCPotion;
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
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityPlayer)
	{
        if (!entityPlayer.capabilities.isCreativeMode)
        	--itemstack.stackSize;
        if (new Random().nextInt(1024) < 4)
        	entityPlayer.addPotionEffect(new PotionEffect(SCPotion.PotionIndigestionID, 30, 0, false));
		return itemstack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 8;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemZongzi");
	}
}
