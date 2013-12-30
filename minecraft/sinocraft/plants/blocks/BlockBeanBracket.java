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
 * 浣滅墿鏋讹紙鏆傛椂鍙敤鍋氳眴绫诲拰榛勭摐锛\x841\xA47
 * @author Liong
 *
 */

// TODO 鍋氬嚭榛勭摐銆侀粍璞嗐\x841\xA47佺豢璞嗐\x841\xA47佺孩璞嗙殑骞艰嫍鍜岃寧鐘舵\x841\xA47\x841\xA47

public class BlockBeanBracket extends Block
{
	Icon blockIcon_Normal;
	Icon blockIcon_Stem;//鑻\x841\xA47
	Icon blockIcon_GrownUp;//鎴愮啛
	
	Icon blockIcon_VignaRadiata_Fruiting;//鎸傛灉缁胯眴鑻\x841\xA47
	Icon blockIcon_VignaAngularis_Fruiting; //鎸傛灉绾㈣眴鑻\x841\xA47
	Icon blockIcon_Cucumber_Fruiting;//鎸傛灉榛勭摐鑻\x841\xA47
		
	public BlockBeanBracket(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setTickRandomly(true);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("BeanBracket");
	
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
				return blockIcon_Stem;
			case 2:
				return blockIcon_GrownUp;
			case 3:
				return blockIcon_VignaRadiata_Fruiting;
			case 4:
				return blockIcon_Stem;
			case 5:
				return blockIcon_GrownUp;
			case 6:
				return blockIcon_VignaAngularis_Fruiting;
			case 7:
				return blockIcon_Stem;
			case 8:
				return blockIcon_GrownUp;
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
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.ItemVignaRadiata, 1, 0));
				break;
		case 3: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.ItemVignaRadiata, world.rand.nextInt(3), 0));
				break;
				
		case 4: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				break;
		case 5: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.ItemVignaAngularis, 1, 0));
				break;
		case 6: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.ItemVignaAngularis, world.rand.nextInt(3), 0));
				break;
				
		case 7: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				break;
		case 8: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.ItemCucumber, 1, 0));
				break;
		case 9: dropBlockAsItem_do(world, x, y, z, new ItemStack(this, 1, 0));
				dropBlockAsItem_do(world, x, y, z, new ItemStack(SCItems.ItemCucumber, world.rand.nextInt(3), 0));
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
		blockIcon_Normal = i.registerIcon("sinocraft:beanbracket_normal");
		blockIcon_Stem = i.registerIcon("sinocraft:beanbracket_germinant");
		blockIcon_GrownUp = i.registerIcon("sinocraft:beanbracket_mature");
		
		blockIcon_VignaRadiata_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_VignaRadiata_Fruiting");
		blockIcon_VignaAngularis_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_VignaAngularis_Fruiting");
		blockIcon_Cucumber_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_Cucumber_Fruiting");
	}
}
