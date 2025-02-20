package com.seiram.eclipserpg.client;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.seiram.eclipserpg.world.inventory.TestUIMenu;
import com.seiram.eclipserpg.network.TestUIButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class TestUIScreen extends AbstractContainerScreen<TestUIMenu> {
    private final static HashMap<String, Object> guistate = TestUIMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_applle;

    public TestUIScreen(TestUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 175;
        this.imageHeight = 71;
    }

    private static final ResourceLocation texture = ResourceLocation.parse("eclipserpg:textures/screens/prueba.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (mouseX > leftPos + -257 && mouseX < leftPos + -233 && mouseY > topPos + 28 && mouseY < topPos + 52)
            guiGraphics.renderTooltip(font, Component.translatable("gui.eclipserpg.test_ui.tooltip_hojitas"), mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/c1e3eb4a-ece2-4ddc-92e7-83175aca0db5.png"), this.leftPos + 151, this.topPos + 5, 0, 0, 16, 16, 16, 16);

        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.translatable("gui.eclipserpg.test_ui.label_empty"), 12, -37, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.eclipserpg.test_ui.label_testui"), 8, 7, -12829636, false);
    }

    @Override
    public void init() {
        super.init();
        button_applle = Button.builder(Component.translatable("gui.eclipserpg.test_ui.button_applle"), e -> {
            if (true) {
                PacketDistributor.sendToServer(new TestUIButtonMessage(0, x, y, z));
                TestUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 177, this.topPos + 72, 61, 20).build();
        guistate.put("button:button_applle", button_applle);
        this.addRenderableWidget(button_applle);
    }
}