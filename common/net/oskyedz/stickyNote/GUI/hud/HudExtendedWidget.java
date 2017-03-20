package net.oskyedz.stickyNote.gui.hud;

import net.minecraft.client.Minecraft;
import net.oskyedz.stickyNote.gui.hud.element.HudElement;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementClockExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementDetailsExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementExperienceExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementFoodExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementHealthExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementHealthMountExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementLevelExtended;
import net.oskyedz.stickyNote.gui.hud.element.extended.HudElementWidgetExtended;
import net.oskyedz.stickyNote.gui.hud.element.vanilla.HudElementHotbarVanilla;
import net.oskyedz.stickyNote.gui.hud.element.vanilla.HudElementPickupVanilla;

public class HudExtendedWidget extends HudDefault {

	public HudExtendedWidget(Minecraft mc, String hudKey, String hudName) {
		super(mc, hudKey, hudName);
	}

	@Override
	public HudElement setElementExperience() {
		return new HudElementExperienceExtended();
	}

	@Override
	public HudElement setElementHealthMount() {
		return new HudElementHealthMountExtended();
	}

	@Override
	public HudElement setElementHotbar() {
		return new HudElementHotbarVanilla();
	}

	@Override
	public HudElement setElementFood() {
		return new HudElementFoodExtended();
	}

	@Override
	public HudElement setElementHealth() {
		return new HudElementHealthExtended();
	}

	@Override
	public HudElement setElementWidget() {
		return new HudElementWidgetExtended();
	}
	
	@Override
	protected HudElement setElementPickup() {
		return new HudElementPickupVanilla();
	}
	
	@Override
	public HudElement setElementClock() {
		return new HudElementClockExtended();
	}
	
	@Override
	public HudElement setElementDetails() {
		return new HudElementDetailsExtended();
	}
	
	@Override
	public HudElement setElementLevel() {
		return new HudElementLevelExtended();
	}
}
