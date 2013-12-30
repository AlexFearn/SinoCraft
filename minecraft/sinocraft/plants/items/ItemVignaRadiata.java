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
 * 缁胯眴
 * @author Liong
 *
 */
public class ItemVignaRadiata extends Item //鐩稿悓鐨勫姛鑳界敤ItemBlock灏卞彲浠ュ疄鐜般€\x82
{
	public ItemVignaRadiata(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("VignaRadiata");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockId(x, y, z) == SCBlocks.blockBeanBracket.blockID)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("sinocraft:vigna_radiata");
	}
}
