package com.seiram.eclipserpg.client;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import com.seiram.eclipserpg.world.inventory.FurnaceGUIMenu;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition7Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition6Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition5Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition4Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition3Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition2Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition1Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition0Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition6Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition5Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition4Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition3Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition2Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition1Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition0Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FurnaceGUIScreen extends AbstractContainerScreen<FurnaceGUIMenu> {
	private final static HashMap<String, Object> guistate = FurnaceGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public FurnaceGUIScreen(FurnaceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("eclipserpg:textures/screens/furnace_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (FurnaceGUIFuelCondition0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_0.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUIFuelCondition1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_1.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUIFuelCondition2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_2.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUIFuelCondition3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_3.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUIFuelCondition4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_4.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUIFuelCondition5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_5.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUIFuelCondition6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_6.png"), this.leftPos + 75, this.topPos + 42, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_0.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_1.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_2.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_3.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_4.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_5.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_6.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
		if (FurnaceGUISmeltingCondition7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/semlt_7.png"), this.leftPos + 91, this.topPos + 52, 0, 0, 12, 12, 12, 12);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.eclipserpg.furnace_gui.label_custom_furnace"), 7, 5, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.eclipserpg.furnace_gui.label_fuel_bnbtintegerfuelremainin"), 114, 6, -13421773, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
