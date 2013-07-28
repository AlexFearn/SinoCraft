package sinocraft.foods.blocks;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
 
public class BlockCookstove extends BlockContainer
{ 
	public BlockCookstove(int Id)
	{
		super(Id, Material.rock);
	}
 
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float xOffset, float yOffset, float zOffset)
	{
		entityplayer.openGui(SinoCraft.instance, SCBlocks.guiCookstoveID, world, x, y, z);
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityCookstove();
	}
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
            System.out.println("wegee");
        }
        if (l == 1)
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);

        if (l == 2)
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);

        if (l == 3)
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);

        if (itemstack.hasDisplayName())// ↓用来给炉子分名字赋值，记得改
            ((TileEntityCookstove)world.getBlockTileEntity(x, y, z)).LocalizeName(itemstack.getDisplayName());
    }
}