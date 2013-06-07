package sinocraft.plants.blocks;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

/**
 * 作物架（暂时只用做豆类）
 * @author Liong
 *
 */

// TODO 做出黄瓜、黄豆、绿豆、红豆的幼苗和茎状态

public class BlockBeanBracket extends Block
{
	Icon blockIcon_Normal;
	Icon blockIcon_VignaRadiata_Sprouts; //绿豆
	Icon blockIcon_VignaAngularis_Sprouts; //红豆
	Icon blockIcon_Cucumber_Sprouts;//黄瓜
	
	public BlockBeanBracket(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
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
				return blockIcon_VignaRadiata_Sprouts;
			case 4:
				return blockIcon_VignaAngularis_Sprouts;
			case 7:
				return blockIcon_Cucumber_Sprouts;
			default:
				return blockIcon_Normal;
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
		blockIcon_VignaRadiata_Sprouts = i.registerIcon("SinoCraft:BlockBeanBracket_VignaRadiata_Sprouts");
		blockIcon_VignaAngularis_Sprouts = i.registerIcon("SinoCraft:BlockBeanBracket_VignaAngularis_Sprouts");
		blockIcon_Cucumber_Sprouts = i.registerIcon("SinoCraft:BlockBeanBracket_Cucumber_Sprouts");
	}
}
