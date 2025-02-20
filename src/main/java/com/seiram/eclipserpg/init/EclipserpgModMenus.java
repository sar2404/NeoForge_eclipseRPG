package com.seiram.eclipserpg.init;

import com.seiram.eclipserpg.world.inventory.CrusherUIMenu;
import com.seiram.eclipserpg.world.inventory.FurnaceGUIMenu;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import com.seiram.eclipserpg.world.inventory.TestUIMenu;
import com.seiram.eclipserpg.EclipseRPG;

public class EclipserpgModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, EclipseRPG.MOD_ID);
    public static final DeferredHolder<MenuType<?>, MenuType<TestUIMenu>> TEST_UI = REGISTRY.register("test_ui", () -> IMenuTypeExtension.create(TestUIMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<FurnaceGUIMenu>> FURNACE_GUI = REGISTRY.register("furnace_gui", () -> IMenuTypeExtension.create(FurnaceGUIMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<CrusherUIMenu>> CRUSHER_UI = REGISTRY.register("crusher_ui", () -> IMenuTypeExtension.create(CrusherUIMenu::new));
}
