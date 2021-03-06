package sinocraft.plants.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.blocks.SCBush;
import sinocraft.core.blocks.SCFlower;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * 茶树
 * @author Liong
 *
 */

public class BlockTeaBush extends SCBush
{
	public BlockTeaBush(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("TeaBush");
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Top = i.registerIcon("sinocraft:BlockTeaBush_Top");
		blockIcon_Leaves = i.registerIcon("sinocraft:BlockTeaBush_Leaves");      
		                       
		blockIcon_Top_Grown = i.registerIcon("sinocraft:BlockTeaBush_Top_Grown");   
		blockIcon_Leaves_Grown = i.registerIcon("sinocraft:BlockTeaBush_Leaves_Grown");
	}
}
