package net.mcreator.scrpg.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;

import net.mcreator.scrpg.world.inventory.StarcraftStatsMenu;
import net.mcreator.scrpg.procedures.XPcountProcedure;
import net.mcreator.scrpg.procedures.StatstrengthProcedure;
import net.mcreator.scrpg.procedures.StatspeedProcedure;
import net.mcreator.scrpg.procedures.StathpProcedure;
import net.mcreator.scrpg.procedures.PointCounterProcedure;
import net.mcreator.scrpg.procedures.LevelProcedure;
import net.mcreator.scrpg.procedures.LevelCondProcedure;
import net.mcreator.scrpg.procedures.FactionZergVisibleCondProcedure;
import net.mcreator.scrpg.network.StarcraftStatsButtonMessage;
import net.mcreator.scrpg.ScrpgMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StarcraftStatsScreen extends AbstractContainerScreen<StarcraftStatsMenu> {
	private final static HashMap<String, Object> guistate = StarcraftStatsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	ImageButton imagebutton_zergicon_gui_basic;

	public StarcraftStatsScreen(StarcraftStatsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("scrpg:textures/screens/starcraft_stats.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				StatstrengthProcedure.execute(world, entity), 56, 10, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_strenght"), 9, 10, -12829636);
		this.font.draw(poseStack,

				StathpProcedure.execute(world, entity), 26, 23, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_hp"), 9, 24, -12829636);
		this.font.draw(poseStack,

				StatspeedProcedure.execute(world, entity), 42, 38, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_speed"), 9, 37, -12829636);
		this.font.draw(poseStack,

				XPcountProcedure.execute(world), 162, 134, -12829636);
		this.font.draw(poseStack,

				LevelCondProcedure.execute(world), 204, 134, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_empty"), 199, 135, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_xp"), 146, 135, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_level"), 146, 149, -12829636);
		this.font.draw(poseStack,

				LevelProcedure.execute(world), 179, 150, -12829636);
		if (FactionZergVisibleCondProcedure.execute(world))
			this.font.draw(poseStack,

					PointCounterProcedure.execute(world), 46, 136, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_points"), 9, 135, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.scrpg.starcraft_stats.button_empty"), e -> {
			if (true) {
				ScrpgMod.PACKET_HANDLER.sendToServer(new StarcraftStatsButtonMessage(0, x, y, z));
				StarcraftStatsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 122, this.topPos + 5, 19, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		imagebutton_zergicon_gui_basic = new ImageButton(this.leftPos + -31, this.topPos + 4, 32, 32, 0, 0, 32, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_zergicon_gui_basic.png"), 32, 64, e -> {
		});
		guistate.put("button:imagebutton_zergicon_gui_basic", imagebutton_zergicon_gui_basic);
		this.addRenderableWidget(imagebutton_zergicon_gui_basic);
	}
}
