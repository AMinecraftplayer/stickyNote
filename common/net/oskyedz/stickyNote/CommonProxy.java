package net.oskyedz.stickyNote;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.oskyedz.stickyNote.init.ModBlocks;
import net.oskyedz.stickyNote.init.ModItems;

/**
 * The common version of the proxy. Everything in here is done on both the
 * client AND the server!
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {

		/**
		 * Regristration of blocks and items. Not models, that's in ClientProxy,
		 * init-phase.
		 */

		ModBlocks.init(); // Blocks and tile entities.

		ModItems.init(); // Items

	}

	public void init(FMLInitializationEvent event) {// Make sure everything is
													// loaded

		// Register recipes. We do this during init to make sure all the blocks
		// and items are registered. Not just those
		// from our mod, but from other mods too!
		ModBlocks.initRecipes();
		ModItems.initRecipes();

	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}
