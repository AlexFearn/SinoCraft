package sinocraft.core.register;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

/**
 * MOD中的合成台合成表注册类
 * @author Liong
 *
 */

public class SCCraftingRecipes
{
	public static void load()
	{
		ModLoader.addRecipe(new ItemStack(SCItems.itemZongzi), new Object[]
		{
			" A ",
			"BCB",
			"   ",
			Character.valueOf('A'), SCItems.itemGlutinousRice,
			Character.valueOf('B'), Item.silk,
			Character.valueOf('C'), SCItems.itemReedLeaves
		});
	}
}
