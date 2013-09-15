package sinocraft.foods.items;

import java.util.ArrayList;
import java.util.List;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * 月饼
 * @author Liong
 *
 */

public class ItemMoonCake extends ItemFood
{
    public static final String[] MoonCakeType = new String[] {"Ham", "SweetBeanPaste", "FiveKernel", "LotusSeedPasteWithEggYolk", "LotusSeedPaste"};
	
    private Icon[] IconArray;
    
	public ItemMoonCake(int Id)
	{
		super(Id, 8, 0.8F, false);
		
		setCreativeTab(SinoCraft.sct);
		setHasSubtypes(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs creativetabs, List list)
	{
		list.add(new ItemStack(itemID, 1, 0));
		list.add(new ItemStack(itemID, 1, 1));
		list.add(new ItemStack(itemID, 1, 2));
		list.add(new ItemStack(itemID, 1, 3));
		list.add(new ItemSeeds(itemID, 1, 4));
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 32;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "item.ItemMoonCake." + MoonCakeType[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		IconArray = new Icon[MoonCakeType.length];
		
		for (int I = 0; I < MoonCakeType.length; I++)
			IconArray[I] = i.registerIcon("sinocraft:ItemMoonCake" + "_" + MoonCakeType[I]);
	}
}
