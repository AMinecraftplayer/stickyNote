package net.oskyedz.lib.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.oskyedz.lib.gui.override.GuiIngameStickyNote;

public class ClientTickHandler {

	/**
	 * Event to change the ingameGui.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		if (!(Minecraft.getMinecraft().ingameGUI instanceof GuiIngameStickyNote))
			Minecraft.getMinecraft().ingameGUI = new GuiIngameStickyNote(Minecraft.getMinecraft());
	}
}
