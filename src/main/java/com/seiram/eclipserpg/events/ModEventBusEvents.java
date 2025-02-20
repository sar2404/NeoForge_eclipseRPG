package com.seiram.eclipserpg.events;

import com.seiram.eclipserpg.EclipseRPG;
import com.seiram.eclipserpg.entity.ModEntities;
import com.seiram.eclipserpg.entity.client.InfectedModel;
import com.seiram.eclipserpg.entity.custom.InfectedEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = EclipseRPG.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(InfectedModel.LAYER_LOCATION, InfectedModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.INFECTED.get(), InfectedEntity.createAttributes().build());

    }

}