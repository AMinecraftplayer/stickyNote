package net.oskyedz.stickyNote.gui.hud.element.vanilla;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.oskyedz.stickyNote.gui.hud.element.HudElement;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;

public class HudElementCrosshairVanilla extends HudElement {

	public HudElementCrosshairVanilla() {
		super(HudElementType.CROSSHAIR, -1, -1, 16, 16, false);
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		ScaledResolution res = new ScaledResolution(this.mc);

		GameSettings gamesettings = this.mc.gameSettings;

		if (gamesettings.thirdPersonView == 0) {
			if(GameData.spectatorStuff()) return;

			int l = res.getScaledWidth();
			int i1 = res.getScaledHeight();

			if (gamesettings.showDebugInfo && !gamesettings.hideGUI && !GameData.getPlayer().hasReducedDebug() && !gamesettings.reducedDebugInfo) {
				GlStateManager.pushMatrix();
				GlStateManager.translate(l / 2, i1 / 2, zLevel);
				Entity entity = this.mc.getRenderViewEntity();
				GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, -1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks, 0.0F, 1.0F, 0.0F);
				GlStateManager.scale(-1.0F, -1.0F, -1.0F);
				GameData.doRenderDirections();
				GlStateManager.popMatrix();
			} else {
				GameData.tryBlendFuncSeparate();
				GlStateManager.enableAlpha();
				gui.drawTexturedModalRect(l / 2 - 7, i1 / 2 - 7, 0, 0, 16, 16);

				if (GameData.getAttackIndicatorSetting() == 1) {
					float f = GameData.getCooledAttackStrength();

					if (f < 1.0F) {
						int i = i1 / 2 - 7 + 16;
						int j = l / 2 - 7;
						int k = (int) (f * 17.0F);
						gui.drawTexturedModalRect(j, i, 36, 94, 16, 4);
						gui.drawTexturedModalRect(j, i, 52, 94, k, 4);
					}
				}
			}
		}
	}
}
