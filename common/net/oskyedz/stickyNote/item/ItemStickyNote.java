package net.oskyedz.stickyNote.item;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.oskyedz.stickyNote.init.ModTileEntity;
import net.oskyedz.stickyNote.lib.Names;
import net.oskyedz.stickyNote.main.ModStickyNote;

/**
 * A very basic item with no subtypes/variants
 */

public class ItemStickyNote extends Item implements ITileEntityProvider, IInventory {

	public static final int GUI_ID = 1;

	public ItemStickyNote() {

		// You can optionally change the max stack size with this method.
		setMaxStackSize(64);
		// If we don't set a creative tab, the block/item won't show up anywhere
		// in the creative menus, but will still
		// appear in JEI.
		setCreativeTab(ModStickyNote.tabStickyNote);
		// Make item render in 3D?
		setFull3D();
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
	public ActionResult<ItemStack> onItemRightClick(World world,
			EntityPlayer player, EnumHand hand) {
		super.onItemRightClick(world, player, hand);

		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote)
			player.openGui(ModStickyNote.instance, 5, player.world, 0, 0, 0);
		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}

	/**
	 * Returns the unlocalized the name for the item. Make sure to add a
	 * corresponding line to your localization file!
	 */
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "item." + ModStickyNote.RESOURCEPREFIX + Names.STICKY_NOTE; // item.stickyNote:stickynote_item

	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {

		return new ModTileEntity();

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
