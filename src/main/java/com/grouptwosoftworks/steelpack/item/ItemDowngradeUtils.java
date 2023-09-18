package com.grouptwosoftworks.steelpack.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.event.level.BlockEvent;

public class ItemDowngradeUtils {

    public interface IDowngradableItem {
        int getSubItemDamage();
        void onItemWillDowngrade(Player player, ItemStack upgradedItemStack);
    }

    public static void handleBlockBreakEvent(BlockEvent.BreakEvent event) {
        // handle only once on server side
        if (event.getLevel().isClientSide()) return;

        // If Items are downgrade-able only
        var item =  event.getPlayer().getMainHandItem().getItem();
        if (! (item instanceof ItemDowngradeUtils.IDowngradableItem)) return;

        var player = event.getPlayer(); // player from event
        var itemStack = player.getMainHandItem(); // item being used
        var damage = item.getDamage(itemStack); // damage to item
        var maxDamage = item.getMaxDamage(itemStack); // max damage to item allowed

        // If item is about to break
        if (damage >= item.getMaxDamage(itemStack) - 1) {
            item.setDamage(itemStack, maxDamage); // make sure it will break
            // handle downgrade
            ((ItemDowngradeUtils.IDowngradableItem) item).onItemWillDowngrade(player, itemStack);
        }
    }

    private static int getUpgradableItemDamage(Player player) {
        var smithingMenu = ((SmithingMenu)player.containerMenu);
        var resultSlotIndex = smithingMenu.getResultSlot();
        for (int i = 0; i < resultSlotIndex; i++) {
            var inputItemStack = smithingMenu.getSlot(i).getItem();
            if (inputItemStack.getItem() instanceof TieredItem tieredItem) {
                return tieredItem.getDamage(inputItemStack);
            }
        }
        return  0;
    }

    public static void givePlayerDowngradedItem(Player player, ItemStack upgradedItemStack, int subItemDamage, TieredItem downgradeItemDef) {
        var downgradeItemStack = new ItemStack(downgradeItemDef, 1);
        var copiedTags = upgradedItemStack.getTag().copy();
        downgradeItemStack.setTag(copiedTags);
        downgradeItemStack.getItem().setDamage(downgradeItemStack, subItemDamage);
        player.addItem(downgradeItemStack);
    }
}
