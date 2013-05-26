package sinocraft;

import sinocraft.register.SCItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class SCCreativeTab extends CreativeTabs{

	public SCCreativeTab(String label) {
		super(label);
		// TODO 自动生成的构造函数存根
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public int getTabIconItemIndex()
    {
        return SCItems.itemReedLeaves.itemID;
    }

}
