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
 * 鏈堥ゼ
 * @author Liong
 *
 */

public class ItemMoonCake extends ItemFood
{
	enum EnumMoonCakeType {
		Ham, SweetBeanPaste, FiveKernel, LotusSeedPasteWithEggYolk, LotusSeedPaste
	}
	
    private Icon[] iconArray;
    
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
		for(int i = 1; i < 5; i ++)
			list.add(new ItemStack(itemID, 1, i));
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 32;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "Mooncake "+EnumMoonCakeType.values()[stack.getItemDamage()].toString();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir)
	{
		iconArray = new Icon[EnumMoonCakeType.values().length];
		
		for (int i = 0; i < EnumMoonCakeType.values().length; i++)
			iconArray[i] = ir.registerIcon("sinocraft:mooncake" + "_" + i);
	}
	
    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int par1)
    {
        return iconArray[par1];
    }
}
