package sinocraft.foods.blocks;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCBlocks;
import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
 
public class BlockCookstove extends BlockContainer
{
	final boolean isActive;
	static boolean keepCookstoveInventory = false;
	
	public BlockCookstove(int Id, boolean isActive)
	{
		super(Id, Material.rock);
		
		this.isActive = isActive;
		
		if (!isActive)
			setCreativeTab(SinoCraft.sct);
		else
			setLightValue(0.875F);

		setHardness(3.5F);
		setUnlocalizedName("Cookstove");
		func_111022_d("sinocraft:BlockCookstove");
	}
 
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float xOffset, float yOffset, float zOffset)
	{
		if (world.isRemote)
			return true;
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		if (tileentity == null || entityplayer.isSneaking())
			return false;
		entityplayer.openGui(SinoCraft.instance, 0, world, x, y, z);
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityCookstove();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int neighbourID, int metadata)
	{
		DropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, neighbourID, metadata);
	}
	
	private void DropItems(World world, int x, int y, int z)
	{
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		
		if(!(tileentity instanceof IInventory))
			return;
		
		IInventory inventory = (IInventory)tileentity;
		
		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack itemstack = inventory.getStackInSlot(i);
			if (itemstack != null && itemstack.stackSize > 0)
			{
				float rx = world.rand.nextFloat() * 0.8F + 0.1F;
				float ry = world.rand.nextFloat() * 0.8F + 0.1F;
				float rz = world.rand.nextFloat() * 0.8F + 0.1F;
				
				EntityItem entityitem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(itemstack.itemID, itemstack.stackSize, itemstack.getItemDamage()));
				
				if (itemstack.hasTagCompound())
					entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
				
				entityitem.motionX = world.rand.nextGaussian() * 0.05F;
				entityitem.motionY = world.rand.nextGaussian() * 0.05F;
				entityitem.motionZ = world.rand.nextGaussian() * 0.05F;
				
				world.spawnEntityInWorld(entityitem);
				itemstack.stackSize = 0;
			}
		}
	}
	
    public static void updateCookstoveBlockState(boolean canBurn, World world, int x, int y, int z)
    {
        int i = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getBlockTileEntity(x, y, z);
        keepCookstoveInventory = true;

        if (canBurn)
        {
            world.setBlock(x, y, z, SCBlocks.blockCookstoveActive.blockID);
        }
        else
        {
            world.setBlock(x, y, z, SCBlocks.blockCookstoveIdle.blockID);
        }

        keepCookstoveInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, i, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setBlockTileEntity(x, y, z, tileentity);
        }
    }
}