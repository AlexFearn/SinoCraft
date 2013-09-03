package sinocraft.foods.items;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 叉烧
 * @author Liong
 *
 */

public class ItemCharSui extends ItemFood
{
	public ItemCharSui(int Id)
	{
		super(Id, 8, 0.8F, false);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("CharSui");
		func_111206_d("sinocraft:ItemCharSui");
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
}
