package sinocraft.foods.items;

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
		func_111206_d("sinocraft:ItemYeungchowFriedRice");
	}
}
