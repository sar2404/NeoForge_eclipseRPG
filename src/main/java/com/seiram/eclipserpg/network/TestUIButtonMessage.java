package com.seiram.eclipserpg.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

import com.seiram.eclipserpg.world.inventory.TestUIMenu;
import com.seiram.eclipserpg.procedures.GoldenapplecrafterProcedure;
import com.seiram.eclipserpg.EclipseRPG;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record TestUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

    // Se añade PacketFlow.SERVERBOUND para indicar que este paquete se envía al servidor
    public static final Type<TestUIButtonMessage> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(EclipseRPG.MOD_ID, "test_ui_buttons"));

    public static final StreamCodec<RegistryFriendlyByteBuf, TestUIButtonMessage> STREAM_CODEC =
            StreamCodec.of((RegistryFriendlyByteBuf buffer, TestUIButtonMessage message) -> {
                buffer.writeInt(message.buttonID);
                buffer.writeInt(message.x);
                buffer.writeInt(message.y);
                buffer.writeInt(message.z);
            }, (RegistryFriendlyByteBuf buffer) -> new TestUIButtonMessage(
                    buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

    @Override
    public Type<TestUIButtonMessage> type() {
        return TYPE;
    }

    public static void handleData(final TestUIButtonMessage message, final IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> {
                Player entity = context.player();
                int buttonID = message.buttonID;
                int x = message.x;
                int y = message.y;
                int z = message.z;
                handleButtonAction(entity, buttonID, x, y, z);
            }).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level();
        HashMap guistate = TestUIMenu.guistate;
        // Medida de seguridad para evitar la generación arbitraria de chunks
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {
            GoldenapplecrafterProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        EclipseRPG.addNetworkMessage(TestUIButtonMessage.TYPE, TestUIButtonMessage.STREAM_CODEC, TestUIButtonMessage::handleData);
    }
}

