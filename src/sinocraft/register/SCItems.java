package sinocraft.register;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sinocraft.plants.items.ItemReedLeaves;
import net.minecraft.item.Item;



public class SCItems {
	public static Item itemReedLeaves;
	public static void load(SCConfig conf) {
		try {
			itemReedLeaves = new ItemReedLeaves(conf.getItemID("itemReedLeaves", 2400));
			
		}catch (Exception e){
			System.err.println("Error when loading itemIDs from config . " + e );
		}
		addItemRecipes();
		
		LanguageRegistry.instance().addNameForObject(itemReedLeaves,
				"zh_CN", "粽叶");
		
		LanguageRegistry.instance().addNameForObject(itemReedLeaves,
				"en_US", "ReedLeaves");
	}
	private static void addItemRecipes() {
		
		
	}

}
