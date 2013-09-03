package sinocraft.foods.items;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBowl extends Item
{
	public ItemBowl(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Bowl");
		func_111206_d("sinocraft:ItemBowl");
	}
}
