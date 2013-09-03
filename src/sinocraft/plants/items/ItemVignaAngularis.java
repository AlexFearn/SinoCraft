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

public class ItemVignaAngularis extends Item
{
	public ItemVignaAngularis(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("VignaAngularis");
		func_111206_d("sinocraft:ItemVignaAngularis");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.getBlockId(x, y, z) == SCBlocks.blockBeanBracket.blockID)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		return true;
	}
}
