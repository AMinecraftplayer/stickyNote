package net.oskyedz.stickyNote.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.oskyedz.stickyNote.stickyNote;
import net.oskyedz.stickyNote.GUI.GuiHandler;
import net.oskyedz.stickyNote.handlers.EnumHandler.StickyNoteTypes;
import net.oskyedz.stickyNote.lib.Names;

// Just like the item's

public class BlockStickyNote extends Block {

	public static final PropertyBool ACTIVATED = PropertyBool
			.create("activated");
	public static final PropertyDirection FACING = PropertyDirection
			.create("facing");
	public static final PropertyEnum TYPE = PropertyEnum.create("type",
			StickyNoteTypes.class);

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

	public BlockStickyNote(String unlocalizedName) {
		super(Material.WOOD);
		this.setDefaultState(this.blockState.getBaseState()
				.withProperty(TYPE, StickyNoteTypes.BASIC)
				.withProperty(FACING, EnumFacing.NORTH)
				.withProperty(ACTIVATED, Boolean.valueOf(false)));
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	/**
	 * Adds the properties to our block
	 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE, FACING,
				ACTIVATED });
	}

	/**
	 * Says redstone can connect
	 */
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world,
			BlockPos pos, EnumFacing side) {
		return side != EnumFacing.UP || side != EnumFacing.DOWN; // Says that as
																	// long as
																	// its not
																	// connected
																	// on top or
																	// bottom it
																	// will
																	// connect
	}

	/**
	 * Replacement of onBlockPlaced in 1.11.2
	 */
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos,
			EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
			EntityLivingBase placer, EnumHand hand) {
		return this
				.getDefaultState()
				.withProperty(FACING,
						EnumFacing.getDirectionFromEntityLiving(pos, placer))
				.withProperty(ACTIVATED, Boolean.valueOf(false))
				.withProperty(
						TYPE,
						getStateFromMeta(meta * EnumFacing.values().length)
								.getValue(TYPE));
	}

	/**
	 * Returns the correct meta for the block I recommend also saving the
	 * EnumFacing to the meta but I haven't
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		StickyNoteTypes type = (StickyNoteTypes) state.getValue(TYPE);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		int meta = type.getID() * EnumFacing.values().length + facing.ordinal(); // Stores
																					// the
																					// type
																					// the
																					// EnumFacing
																					// in
																					// the
																					// meta
		return meta;
	}

	/**
	 * Gets the block state from the meta
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		StickyNoteTypes type = StickyNoteTypes.values()[(int) (meta / EnumFacing
				.values().length) % StickyNoteTypes.values().length]; // Gets
																		// the
																		// type
																		// from
																		// the
																		// meta
		EnumFacing facing = EnumFacing.values()[meta
				% EnumFacing.values().length]; // Gets the EnumFacing from the
												// meta
		return this.getDefaultState().withProperty(TYPE, type)
				.withProperty(FACING, facing); // Returns the correct state
	}

	/**
	 * Makes sure that when you pick block you get the right version of the
	 * block
	 */
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target,
			World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1,
				(int) (getMetaFromState(world.getBlockState(pos)) / EnumFacing
						.values().length));
	}

	/**
	 * Makes the block drop the right version of the block from meta data
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return (int) (getMetaFromState(state) / EnumFacing.values().length);
	}

	/**
	 * Opens our block's gui when the player right clicks on the block
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing heldItem, float side, float hitX, float hitY) {
		if (!worldIn.isRemote) {
			playerIn.openGui(stickyNote.instance, GuiHandler.STICKY_BLOCK,
					worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

}
