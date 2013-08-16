package sinocraft.foods.gui;
 
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import sinocraft.foods.container.ContainerCookstove;
import sinocraft.foods.tileentity.TileEntityCookstove;
 
public class GuiCookstove extends GuiContainer
{
	private TileEntityCookstove tileentity;
	
	public GuiCookstove(TileEntityCookstove tileentity, InventoryPlayer inventory)
	{
		super(new ContainerCookstove(tileentity, inventory));
		
		this.tileentity = tileentity;
		doesGuiPauseGame();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		super.drawGuiContainerForegroundLayer(x, y);
		fontRenderer.drawString(StatCollector.translateToLocal("RepairTable"), 65, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.cookstove"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int x, int y)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.func_110577_a(new ResourceLocation("/gui/cookstove.png"));
		int xOnScreen = (width - xSize) / 2;
		int yOnScreen = (height - ySize) / 2;
		drawTexturedModalRect(xOnScreen, yOnScreen, 0, 0, xSize, ySize);
	}
}