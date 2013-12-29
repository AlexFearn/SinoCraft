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
 * 绮藉瓄1�7
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
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 64;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("sinocraft:Zongzi");
	}
}
