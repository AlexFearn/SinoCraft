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
		
		setUnlocalizedName("Tea Bush");
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Top = i.registerIcon("BlockTeaBush_Top");
		blockIcon_Branch = i.registerIcon("BlockTeaBush_Branch");
		blockIcon_Leaves = i.registerIcon("BlockTeaBush_Leaves");
	}
}
