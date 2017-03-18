package net.oskyedz.stickyNote.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.oskyedz.stickyNote.stickyNote;
import net.oskyedz.stickyNote.lib.Names;

// Just like the item's

public class BlockStickyNote extends Block {

	public BlockStickyNote() {

		super(Material.WOOD); // What material the block should mimic.
		setHardness(5.0f); // The hardness determines how long a block takes to
							// break. 5 is a bit high, most are around 2-3.
		setResistance(10.0f); // Resistance to explosions.
		setSoundType(SoundType.LADDER); // Sound type effects placing, breaking,
										// and step sounds.
		setHarvestLevel("pickaxe", 3);// This method can be used to set a
										// specific tool type and harvest level.
										// Remove if you don't need any
										// restrictions.

		// If we don't set a creative tab, the block/item won't show up anywhere
		// in the creative menus, but will still
		// appear in JEI.
		setCreativeTab(stickyNote.tabStickyNote);
	}

	/**
	 * Add recipes related to the block.
	 */
	public void addRecipes() {

		/*
		 * Shaped recipes require a specific layout, while shapless do not.
		 * Let's break down the first one here:
		 * 
		 * @formatter:off (this turns off the formatter (Ctrl+Shift+F) so it
		 * doesn't screw up this comment)
		 * 
		 * GameRegistry.addShapedRecipe( // addShapedRecipe is for shaped
		 * recipes not using the ore // dicitonary. If you need the oredict, use
		 * // addRecipe(new ShapedOreRecipe(...)) instead. new ItemStack(this),
		 * // The output. You can also specify and count and meta data // if
		 * needed. See the other ItemStack constructors. " l ", // First row.
		 * You can have 1-3 rows. Each row can have 1-3 // characters, but each
		 * row must be the same length! Use // spaces if you want nothing in
		 * that slot. Do not remove // leading or trailing spaces! "lwl", //
		 * Second row " l ", // Third row 'l', Blocks.LADDER, // The remaining
		 * parameters should be pairs of characters // followed by Blocks,
		 * Items, or ItemStacks. You can use // oredict keys as well in
		 * ShapedOreRecipes. 'w', new ItemStack(Blocks.WOOL, 1,
		 * OreDictionary.WILDCARD_VALUE)); // OreDictionary.WILDCARD_VALUE
		 * allows any damage/meta value // to be used.
		 * 
		 * @formatter:on (turn the formatter back on past the section you don't
		 * want it to touch)
		 */

		GameRegistry.addShapedRecipe(new ItemStack(this, 64), " l ", "lwl",
				" l ", 'l', Blocks.LADDER, 'w', new ItemStack(Blocks.WOOL, 1,
						OreDictionary.WILDCARD_VALUE));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 32),
				"dld", "lwl", "dld", 'l', Blocks.LADDER, 'w', Blocks.WOOL, 'd',
				"dyeBlack"));
	}

	@Override
	public String getUnlocalizedName() {

		return "tile." + stickyNote.RESOURCEPREFIX + Names.STICKY_BLOCK; // tile.stickynote:stickynote_block
	}
}
