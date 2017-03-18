package net.oskyedz.stickyNote.item;

import scala.swing.TextComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.oskyedz.stickyNote.stickyNote;
import net.oskyedz.stickyNote.lib.Names;

public class ItemStickyNote extends Item {

	@Override 
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		playerIn.sendMessage(new TextComponentString("You used my item!"));
		return super.onItemRightClick(worldIn, playerIn, handIn);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		
		return "item." + stickyNote.RESOURCEPREFIX + Names.STICKY_NOTE; // item.stickyNote:sticky_note
		
	}
	
}
