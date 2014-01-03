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
 * 鍙夌儳
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
		itemIcon = i.registerIcon("sinocraft:char_sui");
	}
}
