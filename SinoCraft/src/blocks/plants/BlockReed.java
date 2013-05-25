package SinoCraft.blocks.plants;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import SinoCraft.items.ItemReedLeaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockSand;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockReed extends BlockFlower implements IPlantable
{
	public static int blockID;
	
	public BlockReed(int Id)
	{
		super(Id, Material.plants);
		
		blockID = Id;
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("«έ");
	}
	
	@Override
	public int getRenderType()
	{
		return 1;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int idDropped(int par1, Random random, int par3)
	{
		return ItemReedLeaves.itemID;
	}	
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(3);
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return EnumPlantType.Beach;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockReed");
	}
}
