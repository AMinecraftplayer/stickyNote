package net.oskyedz.stickyNote;

import java.util.Random;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = stickyNote.MOD_ID, name = stickyNote.MOD_NAME, version = stickyNote.VERSION, dependencies = stickyNote.DEPENDENCIES)
public class stickyNote {
	
	//Constant
	public static final String MOD_ID = "stickynote";//Must be lowercase 
	public static final String MOD_NAME = "Sticky Notes For Minecraft";//Can be whatever
	public static final String VERSION = "@VERSION@";//Get version from other place, mcmod.info?
	public static final String DEPENDENCIES = ""; //Required-after: given mod need to be loaded, my mod loads after & after: my mod loads after given mod, but not . 
	public static final String RESOURCEPREFIX = MOD_ID.toLowerCase() + ":"; // stickynote:
	
	//Variables
	public static Random random = new Random();
	
	@Instance(MOD_ID)
	public static stickyNote instance;
	
	@SidedProxy(clientSide = "net.oskyedz.stickyNote.ClientProxy", serverSide = "net.oskyedz.stickyNote.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.preInit(event);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.init(event);
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		proxy.postInit(event);
		
	}
}
