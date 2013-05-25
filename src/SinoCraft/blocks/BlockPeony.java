package SinoCraft.blocks;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemPiston;
import net.minecraft.src.ModLoader;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockPeony extends BlockFlower
{
	public BlockPeony(int Id)
	{
		super(Id, Material.plants);
		
		setStepSound(soundGrassFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return blockID;
	}
	
	@Override
	public int getRenderType()
	{
		return 1; //ʹ�ý�����Ⱦ
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockPeony"); //1.5�Բ��ʵ�ʹ�����˸���
	}
}