package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;

public class ItemUpgradeUtils {

    public interface IUpgradableItem {
        void onCraftedBy(ItemStack itemStack, Level level, Player player);
    }

    public static int getDamageOfUpgradableIngredient(Player player) {
        var smithingMenu = ((SmithingMenu)player.containerMenu);
        var resultSlotIndex = smithingMenu.getResultSlot();
        for (int i = 0; i < resultSlotIndex; i++) {
            var inputItemStack = smithingMenu.getSlot(i).getItem();
            if (inputItemStack.getItem() instanceof IUpgradableItem upgradableItem) {
                if (upgradableItem instanceof TieredItem tieredItem) {
                    return tieredItem.getDamage(inputItemStack);
                }
            }
        }
        return  0;
    }
}
