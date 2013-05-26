package sinocraft.core;

import sinocraft.core.register.SCItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class SCCreativeTab extends CreativeTabs {
	
	public SCCreativeTab(String par1Str) {
		super(par1Str);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex(){
		return SCItems.itemReedLeaves.itemID;
		
	}

}
