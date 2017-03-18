package net.oskyedz.stickyNote.init;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.oskyedz.stickyNote.stickyNote;
import net.oskyedz.stickyNote.item.ItemStickyNote;
import net.oskyedz.stickyNote.lib.Names;

public class ModItems {
	
	public static ItemStickyNote stickyNoteItem;
	
	public static void init()  {
		
		stickyNoteItem = new ItemStickyNote();
		stickyNoteItem.setRegistryName(new ResourceLocation(stickyNote.MOD_ID, Names.STICKY_NOTE));
		GameRegistry.register(stickyNoteItem);
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher) {
		
		ModelResourceLocation model = new ModelResourceLocation(stickyNote.RESOURCEPREFIX + Names.STICKY_NOTE, "inventory");
		ModelLoader.registerItemVariants(stickyNoteItem, model);
		mesher.register(stickyNoteItem, 0, model);
		
	}

}
