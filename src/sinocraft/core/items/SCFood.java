package sinocraft.core.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * @author HopeAsd
 * 
 */

public class SCFood extends ItemFood {
	public SCFood(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setCreativeTab(SinoCraft.sct);
	}

	public void onFoodEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		// 在这里添加addPotionEffect方法
	}

	public void addPotionEffect(int par1PotionID, int time, int xiaoguo,
			World par4World, EntityPlayer par5EntityPlayer) {
		if (xiaoguo >= 2) {
			xiaoguo = 0;
			if (!par4World.isRemote && par4World.rand.nextFloat() < 0.1F) {
				par5EntityPlayer.addPotionEffect(new PotionEffect(par1PotionID,
						time * 20, xiaoguo));
			}
		}

	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		// 修改吃好后的掉落物
		return new ItemStack(Item.bowlEmpty);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("sinocraft:"
				+ this.getUnlocalizedName());
	}
}
