package sinocraft.core.register;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import sinocraft.core.SCLog;
import sinocraft.foods.items.ItemZongzi;
import sinocraft.plants.items.ItemBenincasaPruriens;
import sinocraft.plants.items.ItemCucumber;
import sinocraft.plants.items.ItemGlutinousRice;
import sinocraft.plants.items.ItemReedLeaves;
import sinocraft.plants.items.ItemVignaAngularis;
import sinocraft.plants.items.ItemVignaRadiata;

/**
 * MOD中的基础Item注册类
 * @author HopeAsd
 *
 */

public class SCItems
{
	public static ItemReedLeaves itemReedLeaves;
	public static ItemCucumber itemCucumber;
	public static ItemVignaRadiata itemVignaRadiata;
	public static ItemVignaAngularis itemVignaAngularis;
	public static ItemZongzi itemZongzi;
	public static ItemGlutinousRice itemGlutinousRice;
	public static ItemBenincasaPruriens itemBenincasaPruriens;

	public static void load(SCConfig config)
	{
		try
		{
			itemReedLeaves = new ItemReedLeaves(config.getItemID("itemReedLeaves", 2400));
			itemZongzi = new ItemZongzi(config.getItemID("itemZongzi", 2404));
			itemGlutinousRice = new ItemGlutinousRice(config.getItemID("itemGlunousRice", 2405));
			itemBenincasaPruriens = new ItemBenincasaPruriens(config.getItemID("itemBenincasaPruriens", 2406));
			
			itemCucumber = new ItemCucumber(config.getItemID("itemCucumber", 2401));
			itemVignaRadiata = new ItemVignaRadiata(config.getItemID("itemVignaRadiata", 2402));
			itemVignaAngularis = new ItemVignaAngularis(config.getItemID("itemVignaAngularis", 2403));
		}
		catch (Exception e)
		{
			SCLog.info("Error when loading itemIDs from config . " + e);
		}
		
		MinecraftForge.addGrassSeed(new ItemStack(itemGlutinousRice, new Random().nextInt(3)), 4);
		
		
	}
}
