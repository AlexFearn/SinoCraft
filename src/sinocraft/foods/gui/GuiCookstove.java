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
		String s = tileentity.isInvNameLocalized()? tileentity.getInvName() : I18n.getString(tileentity.getInvName());
        fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int x, int y)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(new ResourceLocation("sinocraft:/textures/gui/cookstove.png"));
		//杩欎袱涓彉閲忓皢GUI鏀剧疆浜庢父鎴忕晫闈腑澶\xAE
		//浣嶇疆鍦ㄦ父鎴忕晫闈㈢殑宸︿笂1/16澶\x84
		//					鐣岄潰         GUI
		int midXOnScreen = (width - xSize) / 2;
		int midYOnScreen = (height - ySize) / 2;
		drawTexturedModalRect(midXOnScreen, midYOnScreen, 0, 0, xSize, ySize);
		
		int i;
		
        if (tileentity.time_CookstoveCanKeepBurn > 0)
        {
            i = tileentity.getBurnTimeRemainingScaled(12);
            //					    鐢婚潰涓殑x浣嶇疆		  鐢婚潰涓殑y浣嶇疆				 鏉愯川涓殑u	  鐢婚潰涓殑瀹藉害
            //																		   鏉愯川涓殑v	    鐢婚潰涓殑楂樺害
            drawTexturedModalRect(midXOnScreen + 117, midYOnScreen + 18 + 12 - i, 176, 12 - i, 14, i + 2);
        }
	}
}