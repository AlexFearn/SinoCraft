package sinocraft.register;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sinocraft.SinoCraft;
import sinocraft.plants.items.ItemReedLeaves;
import net.minecraft.item.Item;



/**
 * MOD中的基础Item加载类
 * @author HopeAsd
 *
 */
public class SCItems {
	public static Item itemReedLeaves;
	public static void load(SCConfig conf) {
		try {
			itemReedLeaves = new ItemReedLeaves(conf.getItemID("itemReedLeaves", 2400));
			
		}catch (Exception e){
			SinoCraft.log.warning("Error when loading itemIDs from config . " + e);
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
