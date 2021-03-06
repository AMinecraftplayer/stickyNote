package net.oskyedz.stickyNote.gui.hud.element.modern;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.oskyedz.stickyNote.gui.hud.element.HudElementTexture;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;
import net.oskyedz.stickyNote.main.ModStickyNote;

public class HudElementWidgetModern extends HudElementTexture{

	public HudElementWidgetModern() {
		super(HudElementType.WIDGET, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return GameData.shouldDrawHUD() && ModStickyNote.instance.settings.render_player_face;
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		drawRect(2, 2, 20, 20, 0xA0000000);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		bind(getPlayerSkin(GameData.getPlayer()));
		GlStateManager.disableDepth();
		GL11.glScaled(0.5D, 0.5D, 0.5D);
		gui.drawTexturedModalRect(8, 8, 32, 32, 32, 32);
		gui.drawTexturedModalRect(8, 8, 160, 32, 32, 32);
		GL11.glScaled(2.0D, 2.0D, 2.0D);
	}
}
