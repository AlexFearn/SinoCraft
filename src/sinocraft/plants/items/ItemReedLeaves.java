package sinocraft.plants.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemReedLeaves extends Item
{
	
	public ItemReedLeaves(int Id)
	{
		super(Id);
		
		setCreativeTab(CreativeTabs.tabDecorations);
		this.setUnlocalizedName("reedLeaves");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemReedLeaves");
	}
}
