package sinocraft.blocks;

import sinocraft.core.Annotation.SCBlockAnnotation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SCBlockAnnotation(DefaultID = 500,Name = "Peony")
public class testBlock extends Block {
    public testBlock(int id, Material material) 
    {
        super(id, material);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister i) {
        blockIcon = i.registerIcon("sinocraft:peony");
    }
}