package net.oskyedz.lib.event;

import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.oskyedz.stickyNote.main.ModStickyNote;

public class PlayerContainerHandler {

	/**
	 * Event to set stack sizes of the HUD display to be recalculated again
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onPlayerCloseContainer(PlayerContainerEvent.Close event) {
		ModStickyNote.renderDetailsAgain[0] = true;
		ModStickyNote.renderDetailsAgain[1] = true;
		ModStickyNote.renderDetailsAgain[2] = true;
	}
}
