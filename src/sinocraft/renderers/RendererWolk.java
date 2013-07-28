package sinocraft.renderers;

import javax.swing.Renderer;

import org.lwjgl.opengl.GL11;

import sinocraft.core.register.SCBlocks;
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
		
        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        GL11.glDisable(GL11.GL_LIGHTING);
        int color = block.colorMultiplier(world, x, y, z);
        float f1 = (float)(color >> 16 & 255) / 255.0F;
        float f2 = (float)(color >> 8 & 255) / 255.0F;
        float f3 = (float)(color & 255) / 255.0F;
        
        tessellator.setColorOpaque_F(f1, f2, f3);
        
        //handle
        drawHandles(x, y, z, block, renderer);
		//outside
        renderer.renderStandardBlock(block, x, y, z);
        //inside
		drawInside(x, y, z, block, renderer);
		//bottom
		drawBottom(x, y, z, block, renderer);
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
		return SCBlocks.rendererWolkID;
	}
	
	public void drawOutSide(int x, int y, int z, Block block, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		
		Icon side = block.getIcon(2, 0);
		
        double i = 0.6;
        double j = 0.0001;
		
        double d1 = 0.0625;
        double d2 = 0.9375;
        
        double minU = (double)side.getMinU();
        double minV = (double)side.getMinV();
        double maxU = (double)side.getMaxU();
        double maxV = (double)side.getMaxV();
		tessellator.addVertexWithUV(x + d1, y + i, z + d1, maxU, minV);
		tessellator.addVertexWithUV(x + d1, y + j, z + d1, maxU, maxV);
		tessellator.addVertexWithUV(x + d1, y + j, z + d2, minU, maxV);
		tessellator.addVertexWithUV(x + d1, y + i, z + d2, minU, minV);
		
		tessellator.addVertexWithUV(x + d2, y + i, z + d1, maxU, minV);
		tessellator.addVertexWithUV(x + d2, y + j, z + d1, maxU, maxV);
		tessellator.addVertexWithUV(x + d1, y + j, z + d1, minU, maxV);
		tessellator.addVertexWithUV(x + d1, y + i, z + d1, minU, minV);
		
		tessellator.addVertexWithUV(x + d2, y + i, z + d2, maxU, minV);
		tessellator.addVertexWithUV(x + d2, y + j, z + d2, maxU, maxV);
		tessellator.addVertexWithUV(x + d2, y + j, z + d1, minU, maxV);
		tessellator.addVertexWithUV(x + d2, y + i, z + d1, minU, minV);

		tessellator.addVertexWithUV(x + d1, y + i, z + d2, maxU, minV);
		tessellator.addVertexWithUV(x + d1, y + j, z + d2, maxU, maxV);
		tessellator.addVertexWithUV(x + d2, y + j, z + d2, minU, maxV);
		tessellator.addVertexWithUV(x + d2, y + i, z + d2, minU, minV);
	}
	
	public void drawHandles(int x, int y, int z, Block block, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
        Icon handle = block.getIcon(6, 0);
        
        if(handle == null)
        	handle = renderer.minecraftRB.renderEngine.getMissingIcon(0);
		
        double h = 0.5;
        
        double minU = (double)handle.getMinU();
        double minV = (double)handle.getMinV();
        double maxU = (double)handle.getMaxU();
        double maxV = (double)handle.getMaxV();
		
		//handle 1
        tessellator.addVertexWithUV(x + 0.9375, y + h, z + 1, maxU, maxV);
        tessellator.addVertexWithUV(x + 1.9375, y + h, z + 1, maxU, minV);
        tessellator.addVertexWithUV(x + 1.9375, y + h, z    , minU, minV);
        tessellator.addVertexWithUV(x + 0.9375, y + h, z    , minU, maxV);
        
        tessellator.addVertexWithUV(x + 1.9375, y + h, z    , maxU, minV);
        tessellator.addVertexWithUV(x + 1.9375, y + h, z + 1, minU, minV);
        tessellator.addVertexWithUV(x + 0.9375, y + h, z + 1, minU, maxV);
        tessellator.addVertexWithUV(x + 0.9375, y + h, z    , maxU, maxV);
        //handle 2
		tessellator.addVertexWithUV(x + 0.0625, y + h, z + 1, minU, maxV);
		tessellator.addVertexWithUV(x + 0.0625, y + h, z    , maxU, maxV);
		tessellator.addVertexWithUV(x - 0.9375, y + h, z    , maxU, minV);
		tessellator.addVertexWithUV(x - 0.9375, y + h, z + 1, minU, minV);
		
		tessellator.addVertexWithUV(x - 0.9375, y + h, z    , minU, minV);
		tessellator.addVertexWithUV(x + 0.0625, y + h, z    , minU, maxV);
		tessellator.addVertexWithUV(x + 0.0625, y + h, z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x - 0.9375, y + h, z + 1, maxU, minV);
	}
	
	public void drawInside(int x, int y, int z, Block block, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		
		Icon side = block.getIcon(2, 0);
		
        double j = 0.0001;
		
        double d1 = 0.0625;
        double d2 = 0.9375;
        
        double minU = (double)side.getMinU();
        double minV = (double)side.getMinV();
        double maxU = (double)side.getMaxU();
        double maxV = (double)side.getMaxV();
		
		tessellator.addVertexWithUV(x + d1, y + 1, z + 1, minU, minV);
		tessellator.addVertexWithUV(x + d1, y + j, z + 1, minU, maxV);
		tessellator.addVertexWithUV(x + d1, y + j, z    , maxU, maxV);
		tessellator.addVertexWithUV(x + d1, y + 1, z    , maxU, minV);
		
		tessellator.addVertexWithUV(x    , y + 1, z + d1, minU, minV);
		tessellator.addVertexWithUV(x    , y + j, z + d1, minU, maxV);
		tessellator.addVertexWithUV(x + 1, y + j, z + d1, maxU, maxV);
		tessellator.addVertexWithUV(x + 1, y + 1, z + d1, maxU, minV);
		
		tessellator.addVertexWithUV(x + d2, y + 1, z + 0, minU, minV);
		tessellator.addVertexWithUV(x + d2, y + j, z + 0, minU, maxV);
		tessellator.addVertexWithUV(x + d2, y + j, z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x + d2, y + 1, z + 1, maxU, minV);
		
		tessellator.addVertexWithUV(x + 1, y + 1, z + d2, minU, minV);
		tessellator.addVertexWithUV(x + 1, y + j, z + d2, minU, maxV);
		tessellator.addVertexWithUV(x + 0, y + j, z + d2, maxU, maxV);
		tessellator.addVertexWithUV(x + 0, y + 1, z + d2, maxU, minV);
	}
	
	public void drawBottom(int x, int y, int z, Block block, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		
        Icon bottom = block.getIcon(0, 0);
        
        double j = 0.0001;
		
        double d1 = 0.0625;
        double d2 = 0.9375;
        
        double minU = (double)bottom.getMinU();
        double minV = (double)bottom.getMinV();
        double maxU = (double)bottom.getMaxU();
        double maxV = (double)bottom.getMaxV();
        		
		tessellator.addVertexWithUV(x    , y + j, z    , minU, minV);
		tessellator.addVertexWithUV(x    , y + j, z + 1, minU, maxV);
		tessellator.addVertexWithUV(x + 1, y + j, z + 1, maxU, maxV);
		tessellator.addVertexWithUV(x + 1, y + j, z    , maxU, minV);
	}       
}
