package net.oskyedz.stickyNote;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.oskyedz.stickyNote.GUI.GuiStickyNote;
import net.oskyedz.stickyNote.init.ModBlocks;
import net.oskyedz.stickyNote.init.ModItems;

/**
 * The client-side only version of the proxy. Anything that should be done only
 * on the client should be called from here.
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {

		super.init(event);

		/**
		 * Model regristration has to happen a phase after(init, instead of
		 * preInint) the regristration of the blocks and items themself.
		 */

		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem()
				.getItemModelMesher();

		ModBlocks.initClient(mesher); // Register block models

		ModItems.initClient(mesher); // Register item models
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

		super.postInit(event);
	}

}
