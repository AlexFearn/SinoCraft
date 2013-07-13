package sinocraft.plants.blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.core.blocks.SCBush;
import sinocraft.core.register.SCRenderer;

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
		
		setUnlocalizedName("Jasmine Bush");
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Top = i.registerIcon("BlockJasmineBush_Up");
		blockIcon_Branch = i.registerIcon("BlockJasmineBush_Branch");
		blockIcon_Leaves = i.registerIcon("BlockJasmineBush_Leaves");
	}
}
