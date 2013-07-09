package sinocraft.renderers;

import org.lwjgl.opengl.GL11;

import sinocraft.core.register.SCRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererWolk implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{        
		Tessellator tessellator = Tessellator.instance;
        Icon handle = block.getIcon(6, 0);
        
        if(handle == null)
        {
        	handle = renderer.minecraftRB.renderEngine.getMissingIcon(0);
        }
        
        double h = 0.5;
        double i = 0.6;
        
        double minU = (double)handle.getMinU();
        double minV = (double)handle.getMinV();
        double maxU = (double)handle.getMaxU();
        double maxV = (double)handle.getMaxV();
		
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));

        int color = block.colorMultiplier(world, x, y, z);
        float f1 = (float)(color >> 16 & 255) / 255.0F;
        float f2 = (float)(color >> 8 & 255) / 255.0F;
        float f3 = (float)(color & 255) / 255.0F;
        
        tessellator.setColorOpaque_F(f1, f2, f3);
		//handle 1
        tessellator.addVertexWithUV(x + 1, y + h, z + 1, maxU, maxV);
        tessellator.addVertexWithUV(x + 2, y + h, z + 1, maxU, minV);
        tessellator.addVertexWithUV(x + 2, y + h, z    , minU, minV);
        tessellator.addVertexWithUV(x + 1, y + h, z    , minU, maxV);
        
        tessellator.addVertexWithUV(x + 2, y + h, z    , maxU, minV);
        tessellator.addVertexWithUV(x + 2, y + h, z + 1, minU, minV);
        tessellator.addVertexWithUV(x + 1, y + h, z + 1, minU, maxV);
        tessellator.addVertexWithUV(x + 1, y + h, z    , maxU, maxV);
        //handle 2
		tessellator.addVertexWithUV(x    , y + h, z + 1, minU, maxV);
		tessellator.addVertexWithUV(x    , y + h, z    , maxU, maxV);
		tessellator.addVertexWithUV(x - 1, y + h, z    , maxU, minV);
		tessellator.addVertexWithUV(x - 1, y + h, z + 1, minU, minV);
		
		tessellator.addVertexWithUV(x - 1, y + h, z    , minU, minV);
		tessellator.addVertexWithUV(x    , y + h, z    , minU, maxV);
		tessellator.addVertexWithUV(x    , y + h, z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x - 1, y + h, z + 1, maxU, minV);
		//outside
        renderer.renderStandardBlock(block, x, y, z);
        //inside
		tessellator.addVertexWithUV(x    , y + i, z + 1, minU, minV);
		tessellator.addVertexWithUV(x    , y    , z + 1, minU, maxV);
		tessellator.addVertexWithUV(x    , y    , z    , maxU, maxV);
		tessellator.addVertexWithUV(x    , y + i, z    , maxU, minV);
		
		tessellator.addVertexWithUV(x    , y + i, z    , minU, minV);
		tessellator.addVertexWithUV(x    , y    , z    , minU, maxV);
		tessellator.addVertexWithUV(x + 1, y    , z    , maxU, maxV);
		tessellator.addVertexWithUV(x + 1, y + i, z    , maxU, minV);
		
		tessellator.addVertexWithUV(x + 1, y + i, z    , minU, minV);
		tessellator.addVertexWithUV(x + 1, y    , z    , minU, maxV);
		tessellator.addVertexWithUV(x + 1, y    , z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x + 1, y + i, z + 1, maxU, minV);
		
		tessellator.addVertexWithUV(x + 1, y + i, z + 1, minU, minV);
		tessellator.addVertexWithUV(x + 1, y    , z + 1, minU, maxV);
		tessellator.addVertexWithUV(x    , y    , z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x    , y + i, z + 1, maxU, minV);
		//bottom
		tessellator.addVertexWithUV(x    , y    , z    , minU, minV);
		tessellator.addVertexWithUV(x    , y    , z + 1, minU, maxV);
		tessellator.addVertexWithUV(x + 1, y    , z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x + 1, y    , z    , maxU, minV);
		
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
		return SCRenderer.RendererWolkID;
	}
}
