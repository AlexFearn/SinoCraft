package sinocraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.cooks.Cook;
import sinocraft.core.SCLog;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class SCItemCookbookPage extends Item {

    protected String[] cooklist = new String[] {};
    public SCItemCookbookPage() {
        super();
        this.setMaxDamage(this.cooklist.length);
        this.maxStackSize = 1;
    }

    public SCItemCookbookPage setCooklist(String[] list) {
        this.cooklist = list;
        this.setMaxDamage(this.cooklist.length);
        return this;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (par3EntityPlayer instanceof EntityPlayerMP) {
            if (par3EntityPlayer instanceof EntityPlayerSP) {
                SCLog.log("%s %s %s", par1ItemStack.getClass(), par2World.getClass(), par3EntityPlayer.getClass());
            }
            NBTTagCompound nbtcom = par3EntityPlayer.getEntityData().getCompoundTag("SCCook");
            if (!par3EntityPlayer.getEntityData().hasKey("SCCook")) {
                par3EntityPlayer.getEntityData().setTag("SCCook", nbtcom);
            }
            int i = par1ItemStack.getItemDamage();
            if (i < 0 || i >= this.cooklist.length) {
                i = 0;
            }
            if (!nbtcom.getBoolean(this.cooklist[i])) {
                nbtcom.setBoolean(this.cooklist[i], true);
                par1ItemStack.stackSize = 0;
            }
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
        for (int i = 0; i < this.cooklist.length; ++i) {
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, i));
        }
    }

    public boolean isDamaged(ItemStack stack) {
        return false;
    }

    public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
        int i = par1ItemStack.getItemDamage();
        if (i < 0 || i >= this.cooklist.length) {
            return 0xffffff;
        } else if (Cook.getCook(this.cooklist[i]) != null) {
            return Cook.getCook(this.cooklist[i]).getColor();
        }
        return 0xffffff;
    }

    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int i = par1ItemStack.getItemDamage();

        if (i < 0 || i >= this.cooklist.length) {
            i = 0;
        }
        return super.getUnlocalizedName() + "." + this.cooklist[i];
    }

    public String getItemStackDisplayName(ItemStack par1ItemStack) {
        String pagename = StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(par1ItemStack) + ".name").trim();
        return ("" + StatCollector.translateToLocalFormatted(super.getUnlocalizedName() + ".name", pagename)).trim();
    }

}