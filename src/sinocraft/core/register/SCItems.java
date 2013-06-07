package sinocraft.core.register;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sinocraft.SinoCraft;
import sinocraft.plants.items.ItemCucumber;
import sinocraft.plants.items.ItemReedLeaves;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;

/**
 * MOD中的基础Item注册类
 * @author HopeAsd
 *
 */

public class SCItems
{
	public static ItemReedLeaves itemReedLeaves;
	public static ItemCucumber itemCucumber;

	public static void load(SCConfig config)
	{
		try
		{
			itemReedLeaves = new ItemReedLeaves(config.getItemID("itemReedLeaves", 2400));
			itemCucumber = new ItemCucumber(config.getItemID("itemCucumber", 2401));
		}
		catch (Exception e)
		{
			SinoCraft.log.warning("Error when loading itemIDs from config . " + e);
		}
		
		addItemRecipes();
		
		//itemReedLeaves = new ItemReedLeaves(2400);
		
		ModLoader.addName(itemReedLeaves, "zh_CN", "粽叶");
		ModLoader.addName(itemCucumber, "zh_CN", "黄瓜");
		
		ModLoader.addName(itemReedLeaves, "en_US", "Reed Leaves");
		ModLoader.addName(itemCucumber, "en_US", "Cucumber");
	}
	
	private static void addItemRecipes()
	{
		
	}
}
