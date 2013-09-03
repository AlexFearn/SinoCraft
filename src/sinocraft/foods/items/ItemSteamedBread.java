package sinocraft.foods.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 馒头
 * @author Liong
 *
 */

public class ItemSteamedBread extends ItemFood
{
	public ItemSteamedBread(int Id)
	{
		super(Id, 3, 0.8F, false);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("SteamedBread");
		func_111206_d("sinocraft:ItemSteamedBread");
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
		return 40;
	}
}
