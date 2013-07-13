package sinocraft.foods.gui;

import org.lwjgl.opengl.GL11;

import sinocraft.foods.container.ContainerCookstove;
import sinocraft.foods.tileentity.TileEntityCookstove;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;

public class GuiCookstove extends GuiContainer
{
    private TileEntityCookstove cookstoveInventory;

	public GuiCookstove(TileEntityCookstove tileentity,	InventoryPlayer inventoryplayer)
	{
		super(new ContainerCookstove(tileentity, inventoryplayer));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/furnace.png");
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (cookstoveInventory.isBurning())
        {
            i1 = cookstoveInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }
	}
	
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = cookstoveInventory.isInvNameLocalized() ? cookstoveInventory.getInvName() : StatCollector.translateToLocal(cookstoveInventory.getInvName());
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
}
