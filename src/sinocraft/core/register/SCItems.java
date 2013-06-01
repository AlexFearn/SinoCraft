package sinocraft.core.register;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sinocraft.SinoCraft;
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

	public static void load(/*SCConfig conf*/)
	{
		/*
		try
		{
			itemReedLeaves = new ItemReedLeaves(conf.getItemID("itemReedLeaves", 2400));
		}
		catch (Exception e)
		{
			SinoCraft.log.warning("Error when loading itemIDs from config . " + e);
		}
		*/
		
		addItemRecipes();
		
		itemReedLeaves = new ItemReedLeaves(2400);
		
		ModLoader.addName(itemReedLeaves, "zh_CN", "粽叶");
		
		ModLoader.addName(itemReedLeaves, "en_US", "Reed Leaves");
	}
	
	private static void addItemRecipes()
	{
		
	}
}
