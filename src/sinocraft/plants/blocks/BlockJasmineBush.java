package sinocraft.plants.blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.blocks.SCBush;

/**
 * 茉莉花木
 * @author Liong
 *
 */

public class BlockJasmineBush extends SCBush
{
	public BlockJasmineBush(int Id)
	{
		super(Id);
		
		setCreativeTab(SinoCraft.sct);
		setUnlocalizedName("JasmineBush");
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		func_111022_d("sinocraft:BlockJasmineBush_Up");
		func_111022_d("sinocraft:BlockJasmineBush_Branch");
		func_111022_d("sinocraft:BlockJasmineBush_Leaves");
	}
}
