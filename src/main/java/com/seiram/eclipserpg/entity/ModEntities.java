package com.seiram.eclipserpg.entity;


import com.seiram.eclipserpg.EclipseRPG;
import com.seiram.eclipserpg.entity.custom.InfectedEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
        public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
                DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, EclipseRPG.MOD_ID);



    public static final Supplier<EntityType<InfectedEntity>> INFECTED =
            ENTITY_TYPES.register("infected", () -> EntityType.Builder.of(InfectedEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.8F).build("infected"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
