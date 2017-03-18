package net.oskyedz.stickyNote.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.oskyedz.stickyNote.stickyNote;
import net.oskyedz.stickyNote.lib.Names;

/**
 * A very basic item with no subtypes/variants
 */

public class ItemStickyNote extends Item {

	public ItemStickyNote() {

		// You can optionally change the max stack size with this method.
		setMaxStackSize(64);
		// If we don't set a creative tab, the block/item won't show up anywhere
		// in the creative menus, but will still
		// appear in JEI.
		setCreativeTab(stickyNote.tabStickyNote);
	}

	/**
	 * Add recipes related to the item.
	 */
	public void addRecipes() {

		/*
		 * Shapeless recipes have no specific layout, so we just list each
		 * ingredient. If you have more than one of some ingredient, you must
		 * list it that many times. In this case, it's 2 bones and 1 birch wood
		 * log.
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(this, 4), Items.BONE,
				Items.BONE, new ItemStack(Blocks.LOG, 1, 2));
	}

	/**
	 * Called when the item is right-clicked. By overriding this method, we can
	 * changed the behavior of the item! Note the @Override annotation. You
	 * should use these EVERY TIME you override a method. If the method
	 * signatures change between Minecraft versions (and that happens fairly
	 * often), you will get a compiler error. This makes porting much, much
	 * easier! Otherwise, you'll have a hard time figuring out why certain
	 * methods suddenly aren't being called.
	 */

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn,
			EntityPlayer playerIn, EnumHand handIn) {

		if (!worldIn.isRemote) // send message from server
			playerIn.sendMessage(new TextComponentString("You used my item!"));
		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

	/**
	 * Returns the unlocalized the name for the item. Make sure to add a
	 * corresponding line to your localization file!
	 */
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "item." + stickyNote.RESOURCEPREFIX + Names.STICKY_NOTE; // item.stickyNote:stickynote_item

	}

}
