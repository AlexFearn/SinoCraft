package sinocraft.plants.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.SCLog;
import sinocraft.core.register.SCBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 榛勭摐
 * @author Liong
 *
 */
public class ItemCucumber extends Item
{
	public ItemCucumber(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("Cucumber");
	}
	
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockId(x, y, z) == SCBlocks.blockBeanBracket.blockID)
		{											   //鈫揊lag
			world.setBlockMetadataWithNotify(x, y, z, 7, 3); //Flag 1浠ｈ〃鏂瑰潡鏇存柊锛孎2浠ｈ〃鍙戦€佽嚦瀹㈡埛绔紙鎬绘槸锛夛紝3浠ｈ〃涓嶉噸鏂版覆鏌擄紝鍙互鍙犲姞
		}
		
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:cucumber");
	}
}
