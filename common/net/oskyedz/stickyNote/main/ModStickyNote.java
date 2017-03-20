package net.oskyedz.stickyNote.main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.oskyedz.stickyNote.CommonProxy;
import net.oskyedz.stickyNote.event.ItemPickupHandler;
import net.oskyedz.stickyNote.gui.hud.Hud;
import net.oskyedz.stickyNote.init.ModItems;
import net.oskyedz.stickyNote.settings.ModDebugSettings;
import net.oskyedz.stickyNote.settings.ModSettings;
import net.oskyedz.lib.event.ClientTickHandler;
import net.oskyedz.lib.event.PlayerContainerHandler;
import net.oskyedz.stickyNote.event.PlayerTickHandler;
import net.oskyedz.stickyNote.gui.hud.HudDefault;
import net.oskyedz.stickyNote.gui.hud.HudExtendedWidget;
import net.oskyedz.stickyNote.gui.hud.HudFullTexture;
import net.oskyedz.stickyNote.gui.hud.HudHotbarWidget;
import net.oskyedz.stickyNote.gui.hud.HudModern;
import net.oskyedz.stickyNote.gui.hud.HudVanilla;

//Mod class, starting point for the mod and all it's code.
@Mod(modid = ModStickyNote.MOD_ID, name = ModStickyNote.MOD_NAME, version = ModStickyNote.VERSION, dependencies = ModStickyNote.DEPENDENCIES)
public class ModStickyNote {

	// Constant
	
	// Mod id which the mod is identified with against other mods. Must be lowercase
	public static final String MOD_ID = "stickynote";
	
	// The actual name of the mod as presented to users
	public static final String MOD_NAME = "Osky's Sticky Note's Mod";
	
	// The version number. replace this string with current build number in build.gradle
	public static final String VERSION = "0.0.5";
	
	// Required-after: given mod need to be loaded, my mod loads after & after: my mod loads after given mod or before
	public static final String DEPENDENCIES = ""; 
	
	// "stickynote:" Resource prefix is used for ModelResourceLocations and some other things
	public static final String RESOURCEPREFIX = MOD_ID.toLowerCase() + ":";
	
	/** Path to GuiFactory class of this mod */
	public static final String GUI_FACTORY = "net.oskyedz.stickyNote.gui.GuiFactoryRPGHud";
	
	/** If this mod is client side only */
	public static final boolean CLIENT_SIDE_ONLY = true;

	// Variables
	public static Random random = new Random();// Creates random numbers :)

	@Mod.Instance(MOD_ID)
	
	// THe instance of the mod. Cuz u need a instance.
	public static ModStickyNote instance;
	
	/** The instance of the debug settings of this mod */
	public ModDebugSettings settingsDebug;

	/** The instance of the settings of this mod */
	public ModSettings settings;

	/** Map of all registered HUDs */
	public Map<String, Hud> huds = new LinkedHashMap<String, Hud>();

	/** If the HudElementDetails should be rendered again */
	public static boolean[] renderDetailsAgain = { false, false, false };

	public ItemPickupHandler pickupHandler;

	@SidedProxy(clientSide = "net.oskyedz.stickyNote.ClientProxy", serverSide = "net.oskyedz.stickyNote.CommonProxy")
	// Side proxy, where we define ClientSide(ClientProxy) and
	// ServerSide(CommonProxy) The client inherit the server and add textures
	// and other client related resources.
	public static CommonProxy proxy;

	/**
	 * The function to be run before the initialization
	 * 
	 * @param event
	 *            FMLPreInitializationEvent
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {// Firstly all mods go
															// through preInit
															// (loads up)

		proxy.preInit(event);
		
		this.settings = new ModSettings(Minecraft.getMinecraft().mcDataDir);
		this.settingsDebug = new ModDebugSettings(Minecraft.getMinecraft().mcDataDir);

		this.registerHud(new HudVanilla(Minecraft.getMinecraft(), "vanilla", "Vanilla"));
		this.registerHud(new HudDefault(Minecraft.getMinecraft(), "default", "Default"));
		this.registerHud(new HudExtendedWidget(Minecraft.getMinecraft(), "extended", "Extended Widget"));
		this.registerHud(new HudFullTexture(Minecraft.getMinecraft(), "texture", "Full Texture"));
		this.registerHud(new HudHotbarWidget(Minecraft.getMinecraft(), "hotbar", "Hotbar Widget"));
		this.registerHud(new HudModern(Minecraft.getMinecraft(), "modern", "Modern Style"));

	}

	/**
	 * The function to be run with the initialization
	 * 
	 * @param event
	 *            FMLInitializationEvent
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {// All mods loads into the
													// game.

		proxy.init(event);
		MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerTickHandler());
		this.pickupHandler = new ItemPickupHandler();
		MinecraftForge.EVENT_BUS.register(this.pickupHandler);
		MinecraftForge.EVENT_BUS.register(new PlayerContainerHandler());

	}

	/**
	 * The function to be run after the initialization
	 * 
	 * @param event
	 *            FMLPostInitializationEvent
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if(!isHudKeyValid(this.settings.hud_type)) {
			this.settings.hud_type = "vanilla";
		}	
		proxy.postInit(event);

	}

	public static CreativeTabs tabStickyNote = new CreativeTabs(
			ModStickyNote.RESOURCEPREFIX + "creative_tab") {

		@Override
		public ItemStack getTabIconItem() {

			return new ItemStack(ModItems.stickyNoteItem);
		}
	};
	/**
	 * Register a new HUD
	 * 
	 * @param hud
	 *            he hud to be registered
	 */
	public void registerHud(Hud hud) {
		this.huds.put(hud.getHudKey(), hud);
	}

	/** Returns the active HUD */
	public Hud getActiveHud() {
		return this.huds.get(this.settings.hud_type);
	}

	/** Returns the vanilla HUD */
	public Hud getVanillaHud() {
		return this.huds.get("vanilla");
	}

	/** Checks if a Hud with the specified key is registered */
	public boolean isHudKeyValid(String key) {
		return this.huds.containsKey(key);
	}
}
