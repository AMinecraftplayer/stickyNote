package net.oskyedz.stickyNote.gui.hud.element.hotbar;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.oskyedz.stickyNote.gui.hud.element.HudElementBarred;
import net.oskyedz.stickyNote.gui.hud.element.HudElementType;
import net.oskyedz.lib.GameData;

public class HudElementFoodHotbar extends HudElementBarred {

	public HudElementFoodHotbar() {
		super(HudElementType.FOOD, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return GameData.shouldDrawHUD();
	}
	
	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		int stamina = GameData.getPlayerFood();
		int foodMax = GameData.getPlayerMaxFood();
		ScaledResolution res = new ScaledResolution(this.mc);
		int height = res.getScaledHeight();
		int posX = this.settings.render_player_face ? 49 : 25;
		ItemStack itemMain = GameData.getMainhand();
		ItemStack itemSec = GameData.getOffhand();
		if ((itemMain != GameData.nullStack() && itemMain.getItem() instanceof ItemFood) || (itemSec != GameData.nullStack() && itemSec.getItem() instanceof ItemFood) && GameData.doesPlayerNeedFood() && this.settings.show_hunger_preview) {
			float value;
			if(itemMain.getItem() instanceof ItemFood) 
				value = ((ItemFood) itemMain.getItem()).getHealAmount(itemMain);
			else value = ((ItemFood) itemSec.getItem()).getHealAmount(itemSec);
			int bonusHunger = (int) (value + stamina);
			if (bonusHunger > foodMax)
				bonusHunger = foodMax;
			int colorPreview = offsetColor(this.settings.color_stamina, OFFSET_PREVIEW);
			drawCustomBar(posX, height - 26, 200, 10, bonusHunger / (double)foodMax * 100.0D, -1, -1, colorPreview, offsetColorPercent(colorPreview, OFFSET_PERCENT));
		}
		if (GameData.isPlayerHungered()) {
			drawCustomBar(posX, height - 26, 200, 10, stamina / (double)foodMax * 100.0D, -1, -1, this.settings.color_hunger, offsetColorPercent(this.settings.color_hunger, OFFSET_PERCENT));
		} else {
			drawCustomBar(posX, height - 26, 200, 10, stamina / (double)foodMax * 100.0D, -1, -1, this.settings.color_stamina, offsetColorPercent(this.settings.color_stamina, OFFSET_PERCENT));
		}
		String staminaString = stamina + "/" + foodMax;
		if (this.settings.show_numbers_stamina)
			gui.drawCenteredString(this.mc.fontRendererObj, staminaString, posX + 100, height - 25, -1);
	}

}
