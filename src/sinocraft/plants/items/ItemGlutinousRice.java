package sinocraft.plants.items;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import sinocraft.plants.blocks.BlockGlutinousRice;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlutinousRice extends Item
{
	public ItemGlutinousRice(int Id)
	{
		super(Id);
		
		setUnlocalizedName("Glutinous Rice");
		setCreativeTab(SinoCraft.sct);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		world.setBlock(x, y + 1, z, SCBlocks.blockGlutinousRice.blockID, 0, 3);
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		itemIcon = i.registerIcon("SinoCraft:ItemGlutinousRice");
	}
}
