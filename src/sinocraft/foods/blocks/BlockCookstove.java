package sinocraft.foods.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import scala.util.parsing.ast.Binders.ReturnAndDo;
import sinocraft.SinoCraft;
import sinocraft.core.SCLog;
import sinocraft.core.register.SCBlocks;
import sinocraft.foods.tileentity.TileEntityCookstove;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCookstove extends BlockContainer
{
	Random random = new Random();
	/** 是否在活动状态下 */
	private final boolean isActive;
    /** 防止在燃烧的时候变为静止方块，反之亦然 */
    private static boolean keepInventory = false;
    @SideOnly(Side.CLIENT)
    protected Icon blockIcon_TopOrBottom;
    @SideOnly(Side.CLIENT)
    protected Icon blockIcon_Front;

    public BlockCookstove(int Id, boolean isActive)
    {
        super(Id, Material.rock);
        this.isActive = isActive;
        
        setUnlocalizedName("Cookstove");
        setCreativeTab(SinoCraft.sct);
    }
    
    @Override
    public int idDropped(int par1, Random random, int par3)
    {
        return SCBlocks.blockCookstove.blockID;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int idPicked(World world, int x, int y, int z)
    {
        return SCBlocks.blockCookstove.blockID;
    }
    
    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        setDefaultDirection(world, x, y, z);
    }
    
    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
        	int xFront = world.getBlockId(x + 1, y    , z    );
        	int xBack = world.getBlockId(x - 1, y    , z    );
        	int zFront = world.getBlockId(x    , y    , z + 1);
            int zBack = world.getBlockId(x    , y    , z - 1);
            byte b0 = 2;
            if (Block.opaqueCubeLookup[zFront] && !Block.opaqueCubeLookup[zBack]) //正面向北
                b0 = 2;
            if (Block.opaqueCubeLookup[zBack] && !Block.opaqueCubeLookup[zFront]) //正面向南
            	b0 = 3;
            if (Block.opaqueCubeLookup[xFront] && !Block.opaqueCubeLookup[xBack]) //正面向西
                b0 = 4;
            if (Block.opaqueCubeLookup[xBack] && !Block.opaqueCubeLookup[xFront]) //正面向东
            	b0 = 5;
            
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int metadata)
    {
        return side == 1 ? this.blockIcon_TopOrBottom : (side == 0 ? blockIcon_TopOrBottom : (side != metadata ? blockIcon : blockIcon_Front));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        blockIcon = par1IconRegister.registerIcon("furnace_side");
        blockIcon_Front = par1IconRegister.registerIcon(this.isActive ? "furnace_front_lit" : "furnace_front");
        blockIcon_TopOrBottom = par1IconRegister.registerIcon("furnace_top");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float xOFFset, float yOffset, float zOffset)
    {
        if (world.isRemote)
            return true;
        else
        {
            TileEntityFurnace tileentityfurnace = (TileEntityFurnace)world.getBlockTileEntity(x, y, z);

            if (tileentityfurnace != null)
                entityplayer.openGui(new SinoCraft(), SCBlocks.guiCookstoveID, world, x, y, z);

            return true;
        }
    }

    /**
     * 更新炉子的状态
     */
    public static void updateFurnaceBlockState(boolean isBurning, World world, int x, int y, int z)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getBlockTileEntity(x, y, z);
        keepInventory = true;

        if (isBurning)
            world.setBlock(x, y, z, SCBlocks.blockCookstove_burning.blockID);
        else
            world.setBlock(x, y, z, SCBlocks.blockCookstove.blockID);

        keepInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setBlockTileEntity(x, y, z, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (this.isActive)
        {
            int metadata = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (metadata == 4)
            {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (metadata == 5)
            {
                world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (metadata == 2)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (metadata == 3)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityCookstove();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving, ItemStack itemstack)
    {
        int i = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (i == 0)
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if (i == 1)
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        if (i == 2)
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if (i == 3)
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6)
    {
        if (!keepInventory)
        {
            TileEntityCookstove tileentityCookstove = (TileEntityCookstove)world.getBlockTileEntity(x, y, z);

            if (tileentityCookstove != null)
            {
                for (int i = 0; i < tileentityCookstove.getSizeInventory(); ++i)
                {
                    ItemStack itemstack = tileentityCookstove.getStackInSlot(i);

                    if (itemstack != null)
                    {
                        float f = random.nextFloat() * 0.8F + 0.1F;
                        float f1 = random.nextFloat() * 0.8F + 0.1F;
                        float f2 = random.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = random.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)random.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)random.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
            }
        }

        super.breakBlock(world, x, y, z, par5, par6);
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World world, int x, int y, int z, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)world.getBlockTileEntity(x, y, z));
    }
}
