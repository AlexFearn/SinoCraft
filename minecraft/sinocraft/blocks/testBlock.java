package sinocraft.blocks;

import sinocraft.core.Annotation.SCBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class testBlock extends Block {

	public static testBlock SCBlockPeony;

    public testBlock(int id) 
    {
        super(id, Material.wood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister i) {
        blockIcon = i.registerIcon("sinocraft:peony");
    }

	@SCBlock(DefaultID = 500,Name = "Peony")
	public static Block setPeony(Block b)
	{
		SCBlockPeony = (testBlock)b;
		return b;
	}

}