package sinocraft.foods.blocks;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.block.Block;
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
	boolean isActive;
	
	public BlockCookstove(int Id, boolean isActive)
	{
		super(Id, Material.rock);
		
		this.isActive = isActive;
		setUnlocalizedName("Cookstove");
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
	
	/*
    public static void updateFurnaceBlockState(boolean CanBurn, World world, int par2, int par3, int par4)
    {
        int l = world.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = world.getBlockTileEntity(par2, par3, par4);
        keepFurnaceInventory = true;

        if (CanBurn)
            world.setBlock(par2, par3, par4, Block.furnaceBurning.blockID);
        else
            world.setBlock(par2, par3, par4, Block.furnaceIdle.blockID);

        keepFurnaceInventory = false;
        world.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }
    */
}