package com.seiram.eclipserpg.init;
import com.seiram.eclipserpg.client.FurnaceGUIScreen;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.seiram.eclipserpg.client.TestUIScreen;
import com.seiram.eclipserpg.client.CrusherUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EclipserpgModScreens {
    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {
        event.register(EclipserpgModMenus.TEST_UI.get(), TestUIScreen::new);
        event.register(EclipserpgModMenus.FURNACE_GUI.get(), FurnaceGUIScreen::new);

        event.register(EclipserpgModMenus.CRUSHER_UI.get(), CrusherUIScreen::new);
    }
}

