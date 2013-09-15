package sinocraft.foods.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

/**
 * 扬州炒饭
 * @author Liong
 *
 */

public class ItemYeungchowFriedRice extends ItemFood
{
	public ItemYeungchowFriedRice(int Id)
	{
		super(Id, 8, 0.1F, false);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("YeungchowFriedRice");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("sinocraft:ItemYeungchowFriedRice");
	}
}
