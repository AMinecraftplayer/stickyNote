package net.oskyedz.stickyNote.gui.hud.element.vanilla;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.oskyedz.stickyNote.gui.hud.element.HudElement;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;
import net.oskyedz.lib.gui.override.GuiIngameStickyNote;

public class HudElementArmorVanilla extends HudElement {

	public HudElementArmorVanilla() {
		super(HudElementType.ARMOR, 0, 0, 0, 0, true);
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
		int left = width / 2 - 91;
		int top = height - GuiIngameStickyNote.left_height;

		int level = GameData.getPlayerArmor();
		for (int i = 1; level > 0 && i < 20; i += 2) {
			if (i < level) {
				gui.drawTexturedModalRect(left, top, 34, 9, 9, 9);
			} else if (i == level) {
				gui.drawTexturedModalRect(left, top, 25, 9, 9, 9);
			} else if (i > level) {
				gui.drawTexturedModalRect(left, top, 16, 9, 9, 9);
			}
			left += 8;
		}
		GuiIngameStickyNote.left_height += 10;
	}

}
