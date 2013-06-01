package sinocraft.plants.blocks;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.register.SCItems;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

/**
 * 芦苇
 * @author Liong
 *
 */

public class BlockReed extends BlockFlower implements IPlantable
{
	public BlockReed(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("Reed");
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
		return SCItems.itemReedLeaves.itemID;
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
