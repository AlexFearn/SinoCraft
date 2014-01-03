package sinocraft.core.register;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import sinocraft.SinoCraft;
import sinocraft.core.SCLog;
import sinocraft.foods.items.ItemCharSui;
import sinocraft.foods.items.ItemMoonCake;
import sinocraft.foods.items.ItemSteamedBread;
import sinocraft.foods.items.ItemZongzi;
import sinocraft.plants.items.ItemBenincasaPruriens;
import sinocraft.plants.items.ItemCucumber;
import sinocraft.plants.items.ItemGlutinousRice;
import sinocraft.plants.items.ItemReedLeaves;
import sinocraft.plants.items.ItemVignaAngularis;
import sinocraft.plants.items.ItemVignaRadiata;
import sinocraft.weapon.SinocraftAxe;
import sinocraft.weapon.SinocraftCrutch;
import sinocraft.weapon.SinocraftHammer;
import sinocraft.weapon.SinocraftHook;
import sinocraft.weapon.SinocraftMachete;
import cpw.mods.fml.common.registry.LanguageRegistry;
/**
 * MOD涓殑鍩虹Item娉ㄥ唽绫\x841锟\xBD7
 * @author HopeAsd
 *
 */

public class SCItems
{
	
	public static Item ItemReedLeaves;
	public static Item ItemCucumber;
	public static Item ItemVignaRadiata;
	public static Item ItemVignaAngularis;
	public static Item ItemZongzi;
	public static Item ItemChineseCabbage;
	public static Item ItemCookedZongzi;
	public static Item ItemGlutinousRice;
	public static Item ItemBenincasaPruriens;
	public static Item ItemSteamedBread;
	public static Item ItemCharSui;
	public static Item ItemMoonCake;
	
 //   public static Item ItemFriedRice;
 //   public static Item ItemRice;
	
    //material 
    public static EnumToolMaterial scdamage1 = EnumHelper.addToolMaterial("scdamage1", 3, 300,6.0F, 1.0F, 10);
    public static EnumToolMaterial scdamage2 = EnumHelper.addToolMaterial("scdamage1", 3, 300,6.0F, 2.0F, 10); 
    public static EnumToolMaterial scdamage3 = EnumHelper.addToolMaterial("scdamage1", 3, 300,6.0F, 3.0F, 10);
    public static EnumToolMaterial scdamage4 = EnumHelper.addToolMaterial("scdamage1", 3, 300,6.0F, 4.0F, 10);
    public static EnumToolMaterial scdamage5 = EnumHelper.addToolMaterial("scdamage1", 3, 300,6.0F, 5.0F, 10);
    //weapon
    public static Item SinocraftAxe;
    public static Item SinocraftCrutch;
    public static Item SinocraftHammer;
    public static Item SinocraftHook;
    public static Item SinocraftMachete;
    
    
    
	public static void load(SCConfig config)
	{
		try
		{
			ItemReedLeaves = new ItemReedLeaves(config.getItemID("itemReedLeaves", 3840));
			LanguageRegistry.addName(ItemReedLeaves, "Reed Leaves");
			
			ItemZongzi = new ItemZongzi(config.getItemID("itemZongzi", 3841));
			LanguageRegistry.addName(ItemZongzi, "Zongzi");			
			
			ItemGlutinousRice = new ItemGlutinousRice(config.getItemID("itemGlunousRice", 3842));
			LanguageRegistry.addName(ItemGlutinousRice, "Glutinous Rice");
			ItemBenincasaPruriens = new ItemBenincasaPruriens(config.getItemID("itemBenincasaPruriens", 3843));
			LanguageRegistry.addName(ItemBenincasaPruriens, "Benincasa Pruriens");
			
			ItemMoonCake = new ItemMoonCake(config.getItemID("itemMoonCake", 3849));
			LanguageRegistry.addName(ItemMoonCake, "MoonCake");
			
			ItemVignaAngularis = new ItemVignaAngularis(config.getItemID("itemVignaAngularis", 3846));
			LanguageRegistry.addName(ItemVignaAngularis, "Vigna Angularis");
			
			ItemSteamedBread = new ItemSteamedBread(config.getItemID("itemSteamedBread", 3847));
			LanguageRegistry.addName(ItemSteamedBread, "SteamedBread");
			
			ItemCharSui = new ItemCharSui(config.getItemID("itemCharSui", 3848));
			LanguageRegistry.addName(ItemCharSui, "CharSui");
			
			ItemCucumber = new ItemCucumber(config.getItemID("itemCucumber", 3844));
			LanguageRegistry.addName(ItemCucumber, "Cucumber");
			
			ItemVignaRadiata = new ItemVignaRadiata(config.getItemID("itemVignaRadiata", 3845));
			LanguageRegistry.addName(ItemVignaRadiata, "Vigna Radiata");
		
			
			ItemChineseCabbage = new ItemFood(config.getItemID("itemChineseCabbage", 3847),2,0.1F,false)
            .setUnlocalizedName("ChineseCabbage")
            .setCreativeTab(SinoCraft.sct)
            .setTextureName("sinocraft:chinese_cabbage");
             LanguageRegistry.addName(ItemChineseCabbage, "Chinese Cabbage");
			
             
			ItemCookedZongzi = new ItemFood(config.getItemID("itemCookedZongzi", 3846), 7, 0.6F, true)
			                       .setUnlocalizedName("CookedZongzi")
					               .setCreativeTab(SinoCraft.sct)
			                       .setTextureName("sinocraft:cooked_zongzi");
			LanguageRegistry.addName(ItemCookedZongzi, "CookedZongzi");
			
			
			
/*			ItemFriedRice = new ItemFood(config.getItemID("itemFriedRice", 3847),8,0.7F,false)
			                    .setUnlocalizedName("FriedRice")
			                    .setCreativeTab(SinoCraft.sct)
			                    .setTextureName("sinocraft:FriedRice");
			LanguageRegistry.addName(ItemFriedRice, "fried_rice");
			
			ItemRice = new ItemFood(config.getItemID("itemRice", 3847),4,0.4F,false)
			               .setUnlocalizedName("Rice")
			               .setCreativeTab(SinoCraft.sct)
			               .setTextureName("sinocraft:rice");
			LanguageRegistry.addName(ItemRice, "Rice");
	*/		
	//weapon		
			SinocraftAxe = new SinocraftAxe(config.getItemID("SinocraftAxe",3848),scdamage1)
			               .setCreativeTab(SinoCraft.sct)
			               .setUnlocalizedName("SinocraftAxe")
	                       .setTextureName("sinocraft:sinocraft_axe");
			LanguageRegistry.addName(SinocraftAxe, "Axe");
			
			SinocraftCrutch = new SinocraftCrutch(config.getItemID("SinocraftCrutch",3849),scdamage2)
            .setCreativeTab(SinoCraft.sct)
            .setUnlocalizedName("SinocraftCrutch")
            .setTextureName("sinocraft:sinocraft_crutch");
			LanguageRegistry.addName(SinocraftCrutch, "Crutch");
			
			SinocraftHammer = new SinocraftHammer(config.getItemID("SinocraftHammer",3850),scdamage3)
            .setCreativeTab(SinoCraft.sct)
            .setUnlocalizedName("SinocraftHammer")
            .setTextureName("sinocraft:sinocraft_hammer");
			LanguageRegistry.addName(SinocraftHammer, "Chu��");
			
			SinocraftHook = new SinocraftHook(config.getItemID("SinocraftHook",3851),scdamage1)
            .setCreativeTab(SinoCraft.sct)
            .setUnlocalizedName("SinocraftHook")
            .setTextureName("sinocraft:sinocraft_hook");
			LanguageRegistry.addName(SinocraftHook, "Hook sword");
			
			SinocraftMachete = new SinocraftMachete(config.getItemID("SinocraftMachete",3852),scdamage5)
            .setCreativeTab(SinoCraft.sct)
            .setUnlocalizedName("SinocraftMachete")
            .setTextureName("sinocraft:sinocraft_machete");
			LanguageRegistry.addName(SinocraftMachete, "Machete");
			
		}
		catch (Exception e)
		{
			SCLog.info("Error when loading itemIDs from config . " + e);
		}
		
		MinecraftForge.addGrassSeed(new ItemStack(ItemGlutinousRice, 1), 2);
	}
}

