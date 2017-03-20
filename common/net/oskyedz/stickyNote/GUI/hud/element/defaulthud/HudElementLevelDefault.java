package net.oskyedz.stickyNote.gui.hud.element.defaulthud;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.oskyedz.stickyNote.gui.hud.element.HudElement;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;

public class HudElementLevelDefault extends HudElement {

	public HudElementLevelDefault() {
		super(HudElementType.LEVEL, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return GameData.shouldDrawHUD();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		GlStateManager.disableBlend();
		String level = String.valueOf(GameData.getPlayerXPLevel());
		this.mc.fontRendererObj.drawStringWithShadow(level, (this.settings.render_player_face ? 38 : 12) - this.mc.fontRendererObj.getStringWidth(level) / 2, (this.settings.render_player_face ? 38 : 14), 0x80FF20);
		GlStateManager.enableBlend();
	}

}
