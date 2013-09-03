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
		func_111022_d("sinocraft:BlockTeaBush_Top");
		func_111022_d("sinocraft:BlockTeaBush_Branch");
		func_111022_d("sinocraft:BlockTeaBush_Leaves");
	}
}
