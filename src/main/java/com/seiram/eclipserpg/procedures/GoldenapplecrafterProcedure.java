package com.seiram.eclipserpg.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.function.Supplier;

public class GoldenapplecrafterProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Blocks.OAK_LEAVES.asItem()
                && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.DIRT.asItem()) {
            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                ((Slot) _slots.get(1)).remove(1);
                _player.containerMenu.broadcastChanges();
            }
            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                ((Slot) _slots.get(2)).remove(1);
                _player.containerMenu.broadcastChanges();
            }
            if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                ItemStack _setstack = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE).copy();
                _setstack.setCount((int) (1 + new Object() {
                    public int getAmount(int sltid) {
                        if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                            ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                            if (stack != null)
                                return stack.getCount();
                        }
                        return 0;
                    }
                }.getAmount(3)));
                ((Slot) _slots.get(3)).set(_setstack);
                _player.containerMenu.broadcastChanges();
            }
        }
    }
}
