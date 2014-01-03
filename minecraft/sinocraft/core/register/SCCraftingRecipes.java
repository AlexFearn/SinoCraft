package sinocraft.core.register;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

/**
 * MOD涓殑鍚堟垚鍙板悎鎴愯〃娉ㄥ唽绫\x841\xA47
 * @author Liong
 *
 */

public class SCCraftingRecipes
{
	public static void load()
	{
		GameRegistry.addRecipe(new ItemStack(SCItems.ItemZongzi), new Object[]
		{
			" A ",
			"BCB",
			"   ",
			Character.valueOf('A'), SCItems.ItemGlutinousRice,
			Character.valueOf('B'), Item.silk,
			Character.valueOf('C'), SCItems.ItemReedLeaves
		});
		
	}
}
