package sinocraft.foods.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemYeungchowFriedRice extends Item
{
	public ItemYeungchowFriedRice(int Id)
	{
		super(Id);
	}
	
	@Override
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemYeungchowFriedRice");
	}
}
