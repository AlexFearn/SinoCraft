package sinocraft.plants.blocks;

import java.util.Random;

import sinocraft.SinoCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 牡丹
 * @author Liong
 *
 */

public class BlockPeony extends BlockFlower
{
	public BlockPeony(int Id)
	{
		super(Id, Material.plants);
		
		setCreativeTab(SinoCraft.sct);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("Peony");
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return canBlockStay(world, x, y, z);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y--, z) == dirt.blockID ||
		   world.getBlockId(x, y--, z)	== grass.blockID)
			return true;
		else
			return false;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
	@Override
	public int getRenderType()
	{
		return 1; 
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:BlockPeony");
	}
}