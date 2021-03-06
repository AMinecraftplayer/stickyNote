package net.oskyedz.stickyNote.gui.hud;

import net.minecraft.client.Minecraft;
import net.oskyedz.stickyNote.gui.hud.element.HudElement;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementAirModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementArmorModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementClockModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementCompassModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementDetailsModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementExperienceModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementFoodModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementHealthModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementHealthMountModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementHotbarModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementJumpBarModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementLevelModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementPickupModern;
import net.oskyedz.stickyNote.gui.hud.element.modern.HudElementWidgetModern;

public class HudModern extends HudDefault {

	/** offset position for element */
	private int posX = 0;

	public HudModern(Minecraft mc, String hudKey, String hudName) {
		super(mc, hudKey, hudName);
	}

	/** get the offset position */
	public int getPosX() {
		return this.posX;
	}

	/** set the offset position */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	@Override
	public HudElement setElementAir() {
		return new HudElementAirModern();
	}

	@Override
	public HudElement setElementArmor() {
		return new HudElementArmorModern();
	}

	@Override
	public HudElement setElementClock() {
		return new HudElementClockModern();
	}

	@Override
	public HudElement setElementDetails() {
		return new HudElementDetailsModern();
	}

	@Override
	public HudElement setElementExperience() {
		return new HudElementExperienceModern();
	}

	@Override
	public HudElement setElementFood() {
		return new HudElementFoodModern();
	}

	@Override
	public HudElement setElementHealth() {
		return new HudElementHealthModern();
	}

	@Override
	public HudElement setElementHealthMount() {
		return new HudElementHealthMountModern();
	}

	@Override
	public HudElement setElementHotbar() {
		return new HudElementHotbarModern();
	}

	@Override
	public HudElement setElementJumpBar() {
		return new HudElementJumpBarModern();
	}

	@Override
	public HudElement setElementLevel() {
		return new HudElementLevelModern();
	}

	@Override
	public HudElement setElementWidget() {
		return new HudElementWidgetModern();
	}
	
	@Override
	protected HudElement setElementCompass() {
		return new HudElementCompassModern();
	}
	
	@Override
	protected HudElement setElementPickup() {
		return new HudElementPickupModern();
	}
}
