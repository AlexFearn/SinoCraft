package sinocraft.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

/**
 * @author HopeAsd
 * 
 */

public class SCFood extends ItemFood {
	
	private String iconName = "";

	public SCFood(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
		this.setCreativeTab(SinoCraft.sct);
	}
	public SCFood(int par1,int par2,float par3,boolean par4){
		super(par1,par2,par3,par4);
		this.setCreativeTab(SinoCraft.sct);
	}
	public SCFood(int par1, int par2,float par3, boolean par4,String name) {
		super(par1, par2, par3,par4);
		this.setIAndU(name);
		this.setCreativeTab(SinoCraft.sct);
	}
	public SCFood(int par1, int par2, boolean par3,String name) {
		super(par1, par2, par3);
		this.setIAndU(name);
		this.setCreativeTab(SinoCraft.sct);
	}
	
	public SCFood setIconName(String name) {
		this.iconName = name;
		return this;
	}
	
	/**
	 * 推荐，有助于名字统一 同时设置UnlocalizedName和IconName
	 * 
	 * @param names
	 *            名字
	 */
	public SCFood setIAndU(String names) {
		this.setUnlocalizedName(names);
		this.setIconName(names);
		return this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:"+iconName);
	}

}