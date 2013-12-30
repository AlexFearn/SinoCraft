package sinocraft.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import sinocraft.core.register.SCBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

/**
 * 鐏屾湪娓叉煋鍣\xA8
 * 
 * @author Liong
 * 
 */

public class RendererBush implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;

		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y,
				z));

		double minU = 0D;
		double minV = 0D;
		double maxU = 1D;
		double maxV = 1D;

		float f = 1.0F;
		int l = block.colorMultiplier(world, x, y, z);
		float f1 = (float) (l >> 16 & 255) / 255.0F;
		float f2 = (float) (l >> 8 & 255) / 255.0F;
		float f3 = (float) (l & 255) / 255.0F;

		tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);

		// outside
		renderer.renderStandardBlock(block, x, y, z);
		// inside
		drawInside(x, y, z, block, renderer);
		// branch
		drawCrossedSquares(block, world.getBlockMetadata(x, y, z), x, y, z,
				1.0F, renderer);

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return SCBlocks.rendererBushID;
	}

	public void drawInside(int x, int y, int z, Block block,
			RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		Icon side = block.getIcon(2, 0);

		if (side != null) {
			double minU = side.getMinU();
			double minV = side.getMinV();
			double maxU = side.getMaxU();
			double maxV = side.getMaxV();

			tessellator.addVertexWithUV(x, y + 1, z + 1, minU, minV);
			tessellator.addVertexWithUV(x, y, z + 1, minU, maxV);
			tessellator.addVertexWithUV(x, y, z, maxU, maxV);
			tessellator.addVertexWithUV(x, y + 1, z, maxU, minV);

			tessellator.addVertexWithUV(x, y + 1, z, minU, minV);
			tessellator.addVertexWithUV(x, y, z, minU, maxV);
			tessellator.addVertexWithUV(x + 1, y, z, maxU, maxV);
			tessellator.addVertexWithUV(x + 1, y + 1, z, maxU, minV);

			tessellator.addVertexWithUV(x + 1, y + 1, z, minU, minV);
			tessellator.addVertexWithUV(x + 1, y, z, minU, maxV);
			tessellator.addVertexWithUV(x + 1, y, z + 1, maxU, maxV);
			tessellator.addVertexWithUV(x + 1, y + 1, z + 1, maxU, minV);

			tessellator.addVertexWithUV(x + 1, y + 1, z + 1, minU, minV);
			tessellator.addVertexWithUV(x + 1, y, z + 1, minU, maxV);
			tessellator.addVertexWithUV(x, y, z + 1, maxU, maxV);
			tessellator.addVertexWithUV(x, y + 1, z + 1, maxU, minV);
			// top
			tessellator.addVertexWithUV(x, y + 1, z, minU, minV);
			tessellator.addVertexWithUV(x + 1, y + 1, z, maxU, minV);
			tessellator.addVertexWithUV(x + 1, y + 1, z + 1, maxU, maxV);
			tessellator.addVertexWithUV(x, y + 1, z + 1, minU, maxV);
		}
	}

	public void drawCrossedSquares(Block block, int metadata, double x,
			double y, double z, float par9, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		Icon branch = block.getIcon(6, 0);

		if (branch != null) {

		double minU = (double) branch.getMinU();
		double minV = (double) branch.getMinV();
		double maxU = (double) branch.getMaxU();
		double maxV = (double) branch.getMaxV();
		double d7 = 0.45D * (double) par9;
		double d8 = x + 0.5D - d7;
		double d9 = x + 0.5D + d7;
		double d10 = z + 0.5D - d7;
		double d11 = z + 0.5D + d7;
		tessellator.addVertexWithUV(d8, y + (double) par9, d10, minU, minV);
		tessellator.addVertexWithUV(d8, y + 0.0D, d10, minU, maxV);
		tessellator.addVertexWithUV(d9, y + 0.0D, d11, maxU, maxV);
		tessellator.addVertexWithUV(d9, y + (double) par9, d11, maxU, minV);
		tessellator.addVertexWithUV(d9, y + (double) par9, d11, minU, minV);
		tessellator.addVertexWithUV(d9, y + 0.0D, d11, minU, maxV);
		tessellator.addVertexWithUV(d8, y + 0.0D, d10, maxU, maxV);
		tessellator.addVertexWithUV(d8, y + (double) par9, d10, maxU, minV);
		tessellator.addVertexWithUV(d8, y + par9, d11, minU, minV);
		tessellator.addVertexWithUV(d8, y + 0.0D, d11, minU, maxV);
		tessellator.addVertexWithUV(d9, y + 0.0D, d10, maxU, maxV);
		tessellator.addVertexWithUV(d9, y + par9, d10, maxU, minV);
		tessellator.addVertexWithUV(d9, y + (double) par9, d10, minU, minV);
		tessellator.addVertexWithUV(d9, y + 0.0D, d10, minU, maxV);
		tessellator.addVertexWithUV(d8, y + 0.0D, d11, maxU, maxV);
		tessellator.addVertexWithUV(d8, y + (double) par9, d11, maxU, minV);
		}
	}
}
