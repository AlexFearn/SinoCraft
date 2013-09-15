package sinocraft.foods.items;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 * 盘子
 * @author Liong
 *
 */

public class ItemPlate extends Item
{
	public ItemPlate(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Plate");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("sinocraft:ItemPlate");
	}
}
