package net.oskyedz.stickyNote.gui.hud;

import net.minecraft.client.Minecraft;
import net.oskyedz.stickyNote.gui.hud.element.HudElement;
import net.oskyedz.stickyNote.gui.hud.element.texture.HudElementAirTexture;
import net.oskyedz.stickyNote.gui.hud.element.texture.HudElementExperienceTexture;
import net.oskyedz.stickyNote.gui.hud.element.texture.HudElementFoodTexture;
import net.oskyedz.stickyNote.gui.hud.element.texture.HudElementHealthMountTexture;
import net.oskyedz.stickyNote.gui.hud.element.texture.HudElementHealthTexture;
import net.oskyedz.stickyNote.gui.hud.element.texture.HudElementJumpBarTexture;
import net.oskyedz.stickyNote.gui.hud.element.vanilla.HudElementPickupVanilla;

public class HudFullTexture extends HudExtendedWidget {

	public HudFullTexture(Minecraft mc, String hudKey, String hudName) {
		super(mc, hudKey, hudName);
	}

	@Override
	public HudElement setElementAir() {
		return new HudElementAirTexture();
	}

	@Override
	public HudElement setElementExperience() {
		return new HudElementExperienceTexture();
	}

	@Override
	public HudElement setElementHealth() {
		return new HudElementHealthTexture();
	}

	@Override
	public HudElement setElementHealthMount() {
		return new HudElementHealthMountTexture();
	}

	@Override
	public HudElement setElementJumpBar() {
		return new HudElementJumpBarTexture();
	}

	@Override
	public HudElement setElementFood() {
		return new HudElementFoodTexture();
	}

	@Override
	protected HudElement setElementPickup() {
		return new HudElementPickupVanilla();
	}
}
