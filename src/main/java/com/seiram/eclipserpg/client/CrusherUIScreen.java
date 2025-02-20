package com.seiram.eclipserpg.client;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.seiram.eclipserpg.world.inventory.CrusherUIMenu;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition9Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition8Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition7Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition5Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition4Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition3Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition2Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition1Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition16Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition10Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUISmeltingCondition0Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition9Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition8Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition7Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition6Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition5Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition4Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition3Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition2Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition1Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition10Procedure;
import com.seiram.eclipserpg.procedures.FurnaceGUIFuelCondition0Procedure;

import com.mojang.blaze3d.systems.RenderSystem;

public class CrusherUIScreen extends AbstractContainerScreen<CrusherUIMenu> {
	private final static HashMap<String, Object> guistate = CrusherUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CrusherUIScreen(CrusherUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

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

		guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/crusher_ui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		if (FurnaceGUISmeltingCondition1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_up.png"), this.leftPos + 32, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (FurnaceGUISmeltingCondition2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_down.png"), this.leftPos + 18, this.topPos + 30, 0, 0, 32, 32, 32, 32);
		}
		if (FurnaceGUISmeltingCondition3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_up.png"), this.leftPos + 32, this.topPos + 31, 0, 0, 16, 16, 16, 16);
		}
		if (FurnaceGUISmeltingCondition4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_down.png"), this.leftPos + 18, this.topPos + 30, 0, 0, 32, 32, 32, 32);
		}
		if (FurnaceGUISmeltingCondition5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_up.png"), this.leftPos + 32, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (FurnaceGUISmeltingCondition16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_down.png"), this.leftPos + 18, this.topPos + 30, 0, 0, 32, 32, 32, 32);
		}
		if (FurnaceGUISmeltingCondition7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_up.png"), this.leftPos + 32, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (FurnaceGUISmeltingCondition8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_down.png"), this.leftPos + 18, this.topPos + 30, 0, 0, 32, 32, 32, 32);
		}
		if (FurnaceGUISmeltingCondition9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_up.png"), this.leftPos + 32, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (FurnaceGUISmeltingCondition10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_down.png"), this.leftPos + 18, this.topPos + 30, 0, 0, 32, 32, 32, 32);
		}
		if (FurnaceGUISmeltingCondition0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/hammer_hit_up.png"), this.leftPos + 32, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		}
		if (FurnaceGUIFuelCondition0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_restante0.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel1.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_3.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel4.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel5.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel6.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel7.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel8.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel9.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}
		if (FurnaceGUIFuelCondition10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel10.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
		}



		if (FurnaceGUIFuelCondition2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("eclipserpg:textures/screens/fuel_2.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 16, 64, 16, 64);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.eclipserpg.crusher_ui.label_crusher"), 3, 4, -14408668, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
