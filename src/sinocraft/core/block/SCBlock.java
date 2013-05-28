package sinocraft.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sinocraft.SinoCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
public class SCBlock extends Block{

	public SCBlock(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(SinoCraft.sct);
	}
	public SCBlock(int par1){
		super(par1,Material.rock);
		this.setCreativeTab(SinoCraft.sct);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister i)
	{
		blockIcon = i.registerIcon("SinoCraft:" + this.getUnlocalizedName());
	}
}
