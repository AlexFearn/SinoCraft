package sinocraft.plants.blocks;

import java.util.Random;

import sinocraft.SinoCraft;
import sinocraft.core.register.SCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * 作物架（暂时只用做豆类和黄瓜）
 * @author Liong
 *
 */

// TODO 做出黄瓜、黄豆、绿豆、红豆的幼苗和茎状态

public class BlockBeanBracket extends Block
{
	Icon blockIcon_Normal;
	Icon blockIcon_Germinant;//苗
	Icon blockIcon_Mature;//成熟绿豆苗
	
	Icon blockIcon_VignaRadiata_Fruiting;//挂果绿豆苗
	Icon blockIcon_VignaAngularis_Fruiting; //挂果红豆苗
	Icon blockIcon_Cucumber_Fruiting;//挂果黄瓜苗
		
	public BlockBeanBracket(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setTickRandomly(true);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("BeanBracket");
		func_111022_d("sinocraft:BlockBeanBracket_Normal");
		func_111022_d("sinocraft:BlockBeanBracket_Germinant");
		func_111022_d("sinocraft:BlockBeanBracket_Mature");
		func_111022_d("sinocraft:BlockBeanBracket_VignaRadiata_Fruiting");
		func_111022_d("sinocraft:BlockBeanBracket_VignaAngularis_Fruiting");
		func_111022_d("sinocraft:BlockBeanBracket_Cucumber_Fruiting");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		switch (metadata)
		{
			case 0:
				return blockIcon_Normal;
			case 1:
				return blockIcon_Germinant;
			case 2:
				return blockIcon_Mature;
			case 3:
				return blockIcon_VignaRadiata_Fruiting;
			case 4:
				return blockIcon_Germinant;
			case 5:
				return blockIcon_Mature;
			case 6:
				return blockIcon_VignaAngularis_Fruiting;
			case 7:
				return blockIcon_Germinant;
			case 8:
				return blockIcon_Mature;
			case 9:
				return blockIcon_Cucumber_Fruiting;
			default:
				return blockIcon_Normal;
		}
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float maxRandom, int maxItem)
	{
		switch (metadata)
		{
		case 0: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				break;
		
		case 1: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				break;
		case 2: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemVignaRadiata, 1, 0));
				break;
		case 3: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemVignaRadiata, world.rand.nextInt(3), 0));
				break;
				
		case 4: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				break;
		case 5: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemVignaAngularis, 1, 0));
				break;
		case 6: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemVignaAngularis, world.rand.nextInt(3), 0));
				break;
				
		case 7: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				break;
		case 8: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemCucumber, 1, 0));
				break;
		case 9: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.itemCucumber, world.rand.nextInt(3), 0));
				break;
		default: break;
		}
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(1024) <= 16)
		{
			int metadata = world.getBlockMetadata(x, y, z);
			int metadataUp = world.getBlockMetadata(x, y + 1, z);
			if (metadataUp < metadata)
				if(metadataUp == 1 || metadataUp == 2 || metadataUp == 4 || metadataUp == 5 || metadataUp == 7 || metadataUp == 8)
				{
					world.setBlockMetadataWithNotify(x, y + 1, z, metadataUp + 1, 2);	
					world.setBlockMetadataWithNotify(x, y, z, metadata + 1, 2);
				}
		}
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return canBlockStay(world, x, y, z);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if ((world.getBlockId(x, y - 1, z) == tilledField.blockID ||
			world.getBlockId(x, y - 1, z) == this.blockID) &&
			world.getBlockId(x, y - 4, z) != this.blockID)
			return true;
		return false;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborid)
	{
        if (!canBlockStay(world, x, y, z))
        {
        	dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
	}

	@Override
	public int getRenderType()
	{
		return 1;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Normal = i.registerIcon("SinoCraft:BlockBeanBracket_Normal");
		blockIcon_Germinant = i.registerIcon("SinoCraft:BlockBeanBracket_Germinant");
		blockIcon_Mature = i.registerIcon("SinoCraft:BlockBeanBracket_Mature");
		
		blockIcon_VignaRadiata_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_VignaRadiata_Fruiting");
		blockIcon_VignaAngularis_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_VignaAngularis_Fruiting");
		blockIcon_Cucumber_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_Cucumber_Fruiting");
	}
}
