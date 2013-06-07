package sinocraft.plants.blocks;

import java.util.Random;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
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
	
	Icon blockIcon_VignaRadiata_Germinant; //绿豆苗
	Icon blockIcon_VignaRadiata_Mature;//成熟绿豆苗
	Icon blockIcon_VignaRadiata_Fruiting;//挂果绿豆苗
	
	Icon blockIcon_VignaAngularis_Germinant; //红豆苗
	Icon blockIcon_VignaAngularis_Mature; //成熟红豆苗
	Icon blockIcon_VignaAngularis_Fruiting; //挂果红豆苗
		
	Icon blockIcon_Cucumber_Germinant;//黄瓜苗
	Icon blockIcon_Cucumber_Mature;//成熟黄瓜苗
	Icon blockIcon_Cucumber_Fruiting;//挂果黄瓜苗
		
	public BlockBeanBracket(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setTickRandomly(true);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("Bean Bracket");
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
				return blockIcon_VignaRadiata_Germinant;
			case 2:
				return blockIcon_VignaRadiata_Mature;
			case 3:
				return blockIcon_VignaRadiata_Fruiting;
			case 4:
				return blockIcon_VignaAngularis_Germinant;
			case 5:
				return blockIcon_VignaAngularis_Mature;
			case 6:
				return blockIcon_VignaAngularis_Fruiting;
			case 7:
				return blockIcon_Cucumber_Germinant;
			case 8:
				return blockIcon_Cucumber_Mature;
			case 9:
				return blockIcon_Cucumber_Fruiting;
			default:
				return blockIcon_Normal;
		}
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		int metadataUp = world.getBlockMetadata(x, y + 1, z);
		if (metadataUp < metadata)
			if (metadataUp == 0 || metadataUp == 1 || metadataUp == 2 || metadataUp == 4 || metadataUp == 5 || metadataUp == 7 || metadataUp == 8)
				world.setBlockMetadataWithNotify(x, y + 1, z, metadataUp + 1, 2);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return canBlockStay(world, x, y, z);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if((world.getBlockId(x, y - 1, z) == tilledField.blockID ||
		    world.getBlockId(x, y - 1, z) == this.blockID) &&
		    world.getBlockId(x, y - 4, z) != this.blockID)
			return true;
		return false;
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
	
		blockIcon_VignaRadiata_Germinant = i.registerIcon("SinoCraft:BlockBeanBracket_VignaRadiata_Germinant");
		blockIcon_VignaRadiata_Mature = i.registerIcon("SinoCraft:BlockBeanBracket_VignaRadiata_Mature");
		blockIcon_VignaRadiata_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_VignaRadiata_Fruiting");
			
		blockIcon_VignaAngularis_Germinant = i.registerIcon("SinoCraft:BlockBeanBracket_VignaAngularis_Germinant");
		blockIcon_VignaAngularis_Mature = i.registerIcon("SinoCraft:BlockBeanBracket_VignaAngularis_Mature");
		blockIcon_VignaAngularis_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_VignaAngularis_Fruiting");

		blockIcon_Cucumber_Germinant = i.registerIcon("SinoCraft:BlockBeanBracket_Cucumber_Germinant");
		blockIcon_Cucumber_Mature = i.registerIcon("SinoCraft:BlockBeanBracket_Cucumber_Mature");
		blockIcon_Cucumber_Fruiting = i.registerIcon("SinoCraft:BlockBeanBracket_Cucumber_Fruiting");
	}
}
