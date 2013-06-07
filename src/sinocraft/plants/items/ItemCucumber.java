package sinocraft.plants.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 黄瓜
 * @author Liong
 *
 */

public class ItemCucumber extends Item
{
	public ItemCucumber(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		this.setUnlocalizedName("Cucumber");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockId(x, y, z) == SCBlocks.blockBeanBracket.blockID)
		{											   //↓Flag
			world.setBlockMetadataWithNotify(x, y, z, 7, 3); //Flag 1代表方块更新，Flag 2代表发送至客户端（总是），Flag 3代表不重新渲染，可以叠加
		}
		
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemCucumber");
	}
}
