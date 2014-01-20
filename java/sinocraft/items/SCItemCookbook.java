package sinocraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.cooks.Cook;
import sinocraft.core.SCLog;
import sinocraft.guis.SCGuiCookbook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
// import sinocraft.core.Annotation.SCItem;
// import net.minecraft.item.Item;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
// import net.minecraft.block.material.Material;
// import net.minecraft.client.renderer.texture.IconRegister;
// import cpw.mods.fml.relauncher.Side;
// import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.World;


public class SCItemCookbook extends Item {

    public static SCItemCookbook cookbook;

    public SCItemCookbook() {
        super();
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (par3EntityPlayer instanceof EntityPlayerSP) {
        //     // SCLog.log("%s %s %s", par1ItemStack.getClass(), par2World.getClass(), par3EntityPlayer.getClass());
        //     // Minecraft.getMinecraft().func_147108_a(new SCGuiCookbook(par3EntityPlayer, par1ItemStack, false));
        //     // SCLog.log(par3EntityPlayer.getEntityData().toString());
        // } else
            // SCLog.log("%s %s %s", par1ItemStack.getClass(), par2World.getClass(), par3EntityPlayer.getClass());
            // nbtcom.setBoolean("test1", true);
            // NBTTagCompound nbtcom = par3EntityPlayer.getEntityData().getCompoundTag("SCCook");
            // SCLog.log("test1 :%b test2: %b", nbtcom.getBoolean("test1"), nbtcom.getBoolean("test2"));
        }
        return par1ItemStack;
    }

    // /**
    //  * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
    //  */
    // public boolean getShareTag() {
    //     return true;
    // }

    // public static boolean func_150930_a(NBTTagCompound p_150930_0_) {
    //     if (p_150930_0_ == null) {
    //         return false;
    //     } else if (!p_150930_0_.func_150297_b("pages", 9)) {
    //         return false;
    //     } else {
    //         NBTTagList nbttaglist = p_150930_0_.func_150295_c("pages", 8);

    //         for (int i = 0; i < nbttaglist.tagCount(); ++i) {
    //             String s = nbttaglist.func_150307_f(i);

    //             if (s == null) {
    //                 return false;
    //             }

    //             if (s.length() > 256) {
    //                 return false;
    //             }
    //         }

    //         return true;
    //     }
    // }


}