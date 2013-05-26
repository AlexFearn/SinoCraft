package sinocraft.core;

import sinocraft.core.register.SCItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class SCCreativeTab extends CreativeTabs
{
	
	public SCCreativeTab(String name)
	{
		super(name);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return SCItems.itemReedLeaves.itemID;
	}
}
