package sinocraft.core.register;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import sinocraft.core.SCLog;
import sinocraft.foods.items.*;
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
	public static Item itemReedLeaves;
	public static Item itemCucumber;
	public static Item itemVignaRadiata;
	public static Item itemVignaAngularis;
	public static Item itemZongzi;
	
	public static Item itemGlutinousRice;
	public static Item itemBenincasaPruriens;
	public static Item itemSteamedBread;
	public static Item itemCharSui;
	public static Item itemMoonCake;
	
	public static void load(SCConfig config)
	{
		try
		{
			itemReedLeaves = new ItemReedLeaves(config.getItemID("itemReedLeaves", 3840));
			itemZongzi = new ItemZongzi(config.getItemID("itemZongzi", 3841));
			itemGlutinousRice = new ItemGlutinousRice(config.getItemID("itemGlunousRice", 3842));
			itemBenincasaPruriens = new ItemBenincasaPruriens(config.getItemID("itemBenincasaPruriens", 3843));
			itemCucumber = new ItemCucumber(config.getItemID("itemCucumber", 3844));
			
			itemVignaRadiata = new ItemVignaRadiata(config.getItemID("itemVignaRadiata", 3845));
			itemVignaAngularis = new ItemVignaAngularis(config.getItemID("itemVignaAngularis", 3846));
			itemSteamedBread = new ItemSteamedBread(config.getItemID("itemSteamedBread", 3847));
			itemCharSui = new ItemCharSui(config.getItemID("itemCharSui", 3848));
			itemMoonCake = new ItemMoonCake(config.getItemID("itemMoonCake", 3849));
		}
		catch (Exception e)
		{
			SCLog.info("Error when loading itemIDs from config . " + e);
		}

		MinecraftForge.addGrassSeed(new ItemStack(itemGlutinousRice, new Random().nextInt(3)), 2);
	}
}

