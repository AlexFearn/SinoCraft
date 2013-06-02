package sinocraft.plants.items;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * 粽叶
 * @author Liong
 *
 */

public class ItemReedLeaves extends Item
{
	public ItemReedLeaves(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		this.setUnlocalizedName("Reed Leaves");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemReedLeaves");
	}
}
