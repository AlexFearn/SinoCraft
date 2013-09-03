package sinocraft.foods.gui;
 
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import sinocraft.foods.blocks.BlockCookstove;
import sinocraft.foods.container.ContainerCookstove;
import sinocraft.foods.tileentity.TileEntityCookstove;
 
public class GuiCookstove extends GuiContainer
{
	private TileEntityCookstove tileentity;
	
	public GuiCookstove(TileEntityCookstove tileentity, InventoryPlayer inventory)
	{
		super(new ContainerCookstove(tileentity, inventory));
		
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		String s = tileentity.isInvNameLocalized()? tileentity.getInvName() : I18n.func_135053_a(tileentity.getInvName());
        fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		fontRenderer.drawString(I18n.func_135053_a("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int x, int y)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.func_110577_a(new ResourceLocation("sinocraft:/textures/gui/cookstove.png"));
		//这两个变量将GUI放置于游戏界面中央
		//位置在游戏界面的左上1/16处
		//					界面         GUI
		int midXOnScreen = (width - xSize) / 2;
		int midYOnScreen = (height - ySize) / 2;
		drawTexturedModalRect(midXOnScreen, midYOnScreen, 0, 0, xSize, ySize);
		
		int i;
		
        if (tileentity.time_CookstoveCanKeepBurn > 0)
        {
            i = tileentity.getBurnTimeRemainingScaled(12);
            //					    画面中的x位置		  画面中的y位置				 材质中的u	  画面中的宽度
            //																		   材质中的v	    画面中的高度
            drawTexturedModalRect(midXOnScreen + 117, midYOnScreen + 18 + 12 - i, 176, 12 - i, 14, i + 2);
        }
	}
}