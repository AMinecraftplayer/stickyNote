package net.oskyedz.stickyNote;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * The common version of the proxy. Everything in here is done on both the client AND the server!
 */
public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {//Usually to register blocks and items, not models
		
	}
	
	public void init(FMLInitializationEvent event) {//Make sure everything is loaded
		
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
