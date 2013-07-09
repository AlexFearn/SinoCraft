package sinocraft.foods.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class itemSteamedBread extends ItemFood
{
	public itemSteamedBread(int Id)
	{
		super(Id, 3, 0.8F, false);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Steamed Bread");
	}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if (!entityplayer.capabilities.isCreativeMode)
			--itemstack.stackSize;
		return itemstack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("ItemSteamedBread");
	}
}
