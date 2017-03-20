package net.oskyedz.stickyNote.event;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.oskyedz.stickyNote.main.ModStickyNote;

public class PlayerTickHandler {

	/**
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onWorldTick(PlayerTickEvent event){
		ModStickyNote.instance.pickupHandler.onUpdate();
	}
}
