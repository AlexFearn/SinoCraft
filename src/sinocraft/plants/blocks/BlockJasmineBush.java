package sinocraft.plants.blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import sinocraft.core.blocks.SCBush;

/**
 * 鑼夎帀鑺辨湪
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
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon_Top = i.registerIcon("sinocraft:BlockJasmineBush_Top");
		blockIcon_Leaves = i.registerIcon("sinocraft:BlockJasmineBush_Leaves");      
		                       
		blockIcon_Top_Grown = i.registerIcon("sinocraft:BlockJasmineBush_Top_Grown");   
		blockIcon_Leaves_Grown = i.registerIcon("sinocraft:BlockJasmineBush_Leaves_Grown");
	}
}
