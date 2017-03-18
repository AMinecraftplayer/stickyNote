package net.oskyedz.stickyNote;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.oskyedz.stickyNote.init.ModItems;

//Mod class, starting point for the mod and all it's code.
@Mod(modid = stickyNote.MOD_ID, name = stickyNote.MOD_NAME, version = stickyNote.VERSION, dependencies = stickyNote.DEPENDENCIES)
public class stickyNote {
	
	//Constant
	public static final String MOD_ID = "stickynote";//Mod id which the mod is identified with against other mods.  Must be lowercase 
	public static final String MOD_NAME = "Osky's Sticky Note's Mod";//The actual name of the mod as presented to users
	public static final String VERSION = "@VERSION@";//The version number. replace this string with current build number in build.gradle 
	public static final String DEPENDENCIES = ""; //Required-after: given mod need to be loaded, my mod loads after & after: my mod loads after given mod or before
	public static final String RESOURCEPREFIX = MOD_ID.toLowerCase() + ":"; // "stickynote:" Resource prefix is used for ModelResourceLocations and some other things
	
	//Variables
	public static Random random = new Random();//Creates random numbers :)
	
	@Instance(MOD_ID)
	public static stickyNote instance;//THe instance of the mod. Cuz u need a instance.
	
	@SidedProxy(clientSide = "net.oskyedz.stickyNote.ClientProxy", serverSide = "net.oskyedz.stickyNote.CommonProxy")//Side proxy, where we define ClientSide(ClientProxy) and ServerSide(CommonProxy) The client inherit the server and add textures and other client related resources.
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {//Firstly all mods go through preInit (loads up)
		
		proxy.preInit(event);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {//All mods loads into the game.
		
		proxy.init(event);
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {//Lastly mods finishing goes through post-init 
		
		proxy.postInit(event);
		
	}
	
	public static CreativeTabs tabStickyNote = new CreativeTabs(StickyNote.RESOURCEPREFIX + "creative_tab") {

		@Override
		public ItemStack getTabIconItem() {

			return new ItemStack(ModItems.stickyNoteItem);
		}
	};
}
