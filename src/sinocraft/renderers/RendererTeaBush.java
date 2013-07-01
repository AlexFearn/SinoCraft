package sinocraft.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import sinocraft.core.register.SCRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

/**
 * 茶树渲染器
 * @author Liong
 *
 */

public class RendererTeaBush implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        float f = 1.0F;
        int l = block.colorMultiplier(world, x, y, z);
        float red = (float)(l >> 16 & 255) / 255.0F;
        float green = (float)(l >> 8 & 255) / 255.0F;
        float blue = (float)(l & 255) / 255.0F;

        if (EntityRenderer.anaglyphEnable)
        {
            float f4 = (red * 30.0F + green * 59.0F + blue * 11.0F) / 100.0F;
            float f5 = (red * 30.0F + green * 70.0F) / 100.0F;
            float f6 = (red * 30.0F + blue * 70.0F) / 100.0F;
            red = f4;
            green = f5;
            blue = f6;
        }

        tessellator.setColorOpaque_F(f * red, f * green, f * blue);
        
        drawCrossedSquares(block, world.getBlockMetadata(x, y, z), (double)x, (double)y, (double)z, 1.0F, renderer);
        GL11.glDisable(GL11.GL_CULL_FACE);
        renderer.renderStandardBlock(block, x, y, z);
        return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return SCRenderer.RendererTeaBushID;
	}
	
    public void drawCrossedSquares(Block block, int metadata, double x, double y, double z, float par9, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;
        Icon branch = block.getIcon(6, 0);
        
        if(branch == null)
        {
        	branch = renderer.minecraftRB.renderEngine.getMissingIcon(0);
        }
        
        double minU = (double)branch.getMinU();
        double minV = (double)branch.getMinV();
        double maxU = (double)branch.getMaxU();
        double maxV = (double)branch.getMaxV();
        double d7 = 0.45D * (double)par9;
        double d8 = x + 0.5D - d7;
        double d9 = x + 0.5D + d7;
        double d10 = z + 0.5D - d7;
        double d11 = z + 0.5D + d7;
        tessellator.addVertexWithUV(d8, y + (double)par9, d10, minU, minV);
        tessellator.addVertexWithUV(d8, y + 0.0D, d10, minU, maxV);
        tessellator.addVertexWithUV(d9, y + 0.0D, d11, maxU, maxV);
        tessellator.addVertexWithUV(d9, y + (double)par9, d11, maxU, minV);
        tessellator.addVertexWithUV(d9, y + (double)par9, d11, minU, minV);
        tessellator.addVertexWithUV(d9, y + 0.0D, d11, minU, maxV);
        tessellator.addVertexWithUV(d8, y + 0.0D, d10, maxU, maxV);
        tessellator.addVertexWithUV(d8, y + (double)par9, d10, maxU, minV);
        tessellator.addVertexWithUV(d8, y + (double)par9, d11, minU, minV);
        tessellator.addVertexWithUV(d8, y + 0.0D, d11, minU, maxV);
        tessellator.addVertexWithUV(d9, y + 0.0D, d10, maxU, maxV);
        tessellator.addVertexWithUV(d9, y + (double)par9, d10, maxU, minV);
        tessellator.addVertexWithUV(d9, y + (double)par9, d10, minU, minV);
        tessellator.addVertexWithUV(d9, y + 0.0D, d10, minU, maxV);
        tessellator.addVertexWithUV(d8, y + 0.0D, d11, maxU, maxV);
        tessellator.addVertexWithUV(d8, y + (double)par9, d11, maxU, minV);
    }
}
