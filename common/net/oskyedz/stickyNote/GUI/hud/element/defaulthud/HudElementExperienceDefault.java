package net.oskyedz.stickyNote.gui.hud.element.defaulthud;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.oskyedz.stickyNote.gui.hud.element.HudElementBarred;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;

public class HudElementExperienceDefault extends HudElementBarred {

	public HudElementExperienceDefault() {
		super(HudElementType.EXPERIENCE, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return GameData.shouldDrawHUD();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		ScaledResolution res = new ScaledResolution(this.mc);
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();
		int exp = GameData.getPlayerXP();
		int expCap = GameData.getPlayerXPCap();
		double full = 100D / expCap;
		GlStateManager.disableLighting();
		drawCustomBar(0, height - 10, width, 10, exp * full, this.settings.color_experience, offsetColorPercent(this.settings.color_experience, 25));
		String stringExp = exp + "/" + expCap;
		int var7 = width / 2;
		if (this.settings.show_numbers_experience)
			gui.drawCenteredString(this.mc.fontRendererObj, stringExp, var7, height - 9, -1);
	}

}
