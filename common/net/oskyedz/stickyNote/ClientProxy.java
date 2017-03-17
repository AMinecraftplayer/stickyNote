package net.oskyedz.stickyNote;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * The client-side only version of the proxy. Anything that should be done only on the client should be called from
 * here.
 */
public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
		super.postInit(event);
	}

}
