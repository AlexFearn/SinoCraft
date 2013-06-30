package sinocraft.core.register;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sinocraft.core.SCLog;
import sinocraft.foods.items.ItemZongzi;
import sinocraft.plants.items.ItemBenincasaPruriens;
import sinocraft.plants.items.ItemCucumber;
import sinocraft.plants.items.ItemGlutinousRice;
import sinocraft.plants.items.ItemReedLeaves;
import sinocraft.plants.items.ItemVignaAngularis;
import sinocraft.plants.items.ItemVignaRadiata;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

/**
 * MOD中的基础Item注册类
 * @author HopeAsd
 *
 */

public class SCItems
{
	public static ItemReedLeaves itemReedLeaves;
	//public static ItemCucumber itemCucumber;
	//public static ItemVignaRadiata itemVignaRadiata;
	//public static ItemVignaAngularis itemVignaAngularis;
	public static ItemZongzi itemZongzi;
	public static ItemGlutinousRice itemGlutinousRice;
	public static ItemBenincasaPruriens itemBenincasaPruriens;

	public static void load(SCConfig config)
	{
		try
		{
			itemReedLeaves = new ItemReedLeaves(config.getItemID("itemReedLeaves", 2400));
			//itemCucumber = new ItemCucumber(config.getItemID("itemCucumber", 2401));
			//itemVignaRadiata = new ItemVignaRadiata(config.getItemID("itemVignaRadiata", 2402));
			//itemVignaAngularis = new ItemVignaAngularis(config.getItemID("itemVignaAngularis", 2403));
			itemZongzi = new ItemZongzi(config.getItemID("itemZongzi", 2404));
			itemGlutinousRice = new ItemGlutinousRice(config.getItemID("itemGlunousRice", 2405));
			itemBenincasaPruriens = new ItemBenincasaPruriens(config.getItemID("itemBenincasaPruriens", 2406));
		}
		catch (Exception e)
		{
			SCLog.info("Error when loading itemIDs from config . " + e);
		}
		
<<<<<<< HEAD
		addItemRecipes();
			
	}
	
	private static void addItemRecipes()
	{
		ModLoader.addRecipe(new ItemStack(itemZongzi), new Object[]
		{
			" A ",
			"BCB",
			"  ",
			Character.valueOf('A'), itemGlutinousRice,
			Character.valueOf('B'), Item.silk,
			Character.valueOf('C'), itemReedLeaves
		});
=======
		ModLoader.addName(itemReedLeaves, "zh_CN", "粽叶");
		//ModLoader.addName(itemCucumber, "zh_CN", "黄瓜");
		//ModLoader.addName(itemVignaRadiata, "zh_CN", "绿豆");
		//ModLoader.addName(itemVignaAngularis, "zh_CN", "红豆");
		ModLoader.addName(itemZongzi, "zh_CN", "粽子");
		ModLoader.addName(itemGlutinousRice, "zh_CN", "糯米");
		ModLoader.addName(itemBenincasaPruriens, "zh_CN", "白菜");
		
		ModLoader.addName(itemReedLeaves, "en_US", "Reed Leaves");
		//ModLoader.addName(itemCucumber, "en_US", "Cucumber");
		//ModLoader.addName(itemVignaRadiata, "en_US", "Vigna Radiata");
		//ModLoader.addName(itemVignaAngularis, "en_US", "Vigna Angularis");
		ModLoader.addName(itemZongzi, "en_US", "Zongzi");
		ModLoader.addName(itemGlutinousRice, "en_US", "Glutinous Rice");
		ModLoader.addName(itemBenincasaPruriens, "en_US", "Benincasa Pruriens");
>>>>>>> origin/release
	}
}
