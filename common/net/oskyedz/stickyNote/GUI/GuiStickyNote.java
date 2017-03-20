package net.oskyedz.stickyNote.GUI;

import static org.lwjgl.opengl.GL11.glEnable;

import java.io.IOException;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiStickyNote extends GuiScreen  {
	private boolean mouseDown = false;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);

		glEnable(32826);
		GlStateManager.pushMatrix();

		RenderHelper.enableGUIStandardItemLighting();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		mouseDown = true;
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
