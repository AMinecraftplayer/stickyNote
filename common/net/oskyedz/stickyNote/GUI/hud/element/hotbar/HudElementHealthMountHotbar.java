package net.oskyedz.stickyNote.gui.hud.element.hotbar;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.oskyedz.stickyNote.gui.hud.element.HudElementBarred;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;

public class HudElementHealthMountHotbar extends HudElementBarred {

	public HudElementHealthMountHotbar() {
		super(HudElementType.HEALTH_MOUNT, 0, 0, 0, 0, false);
	}

	@Override
	public boolean checkConditions() {
		return GameData.isRidingLivingMount() && GameData.shouldDrawHUD();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		ScaledResolution res = new ScaledResolution(this.mc);
		int height = res.getScaledHeight();
		EntityLivingBase mount = (EntityLivingBase) GameData.getMount();
		int health = (int) Math.ceil(mount.getHealth());
		int healthMax = (int) mount.getMaxHealth();
		int posX = this.settings.render_player_face ? 49 : 25;
		drawCustomBar(posX, height - 56, 200, 10, (double) health / (double) healthMax * 100.0D, -1, -1, this.settings.color_health, offsetColorPercent(this.settings.color_health, OFFSET_PERCENT));
		String stringHealth = health + "/" + healthMax;

		if (this.settings.show_numbers_health)
			gui.drawCenteredString(this.mc.fontRendererObj, stringHealth, posX + 100, height - 55, -1);
	}

}
