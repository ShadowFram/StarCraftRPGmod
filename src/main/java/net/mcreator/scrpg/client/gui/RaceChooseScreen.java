package net.mcreator.scrpg.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;

import net.mcreator.scrpg.world.inventory.RaceChooseMenu;
import net.mcreator.scrpg.network.RaceChooseButtonMessage;
import net.mcreator.scrpg.ScrpgMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RaceChooseScreen extends AbstractContainerScreen<RaceChooseMenu> {
	private final static HashMap<String, Object> guistate = RaceChooseMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_protoss;
	ImageButton imagebutton_zerg;
	ImageButton imagebutton_terrans;

	public RaceChooseScreen(RaceChooseMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("scrpg:textures/screens/race_choose.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("scrpg:textures/screens/yn262f88um011_photo-resizer.ru.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + -1, 0, 0, 300, 169, 300, 169);

		RenderSystem.setShaderTexture(0, new ResourceLocation("scrpg:textures/screens/ui_down.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 169, 0, 0, 300, 40, 300, 40);

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
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_protoss = new ImageButton(this.leftPos + -89, this.topPos + 119, 289, 142, 0, 0, 142, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_protoss.png"), 289, 284, e -> {
		});
		guistate.put("button:imagebutton_protoss", imagebutton_protoss);
		this.addRenderableWidget(imagebutton_protoss);
		imagebutton_zerg = new ImageButton(this.leftPos + 16, this.topPos + 119, 289, 142, 0, 0, 142, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_zerg.png"), 289, 284, e -> {
			if (true) {
				ScrpgMod.PACKET_HANDLER.sendToServer(new RaceChooseButtonMessage(1, x, y, z));
				RaceChooseButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_zerg", imagebutton_zerg);
		this.addRenderableWidget(imagebutton_zerg);
		imagebutton_terrans = new ImageButton(this.leftPos + 107, this.topPos + 121, 289, 142, 0, 0, 142, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_terrans.png"), 289, 284, e -> {
		});
		guistate.put("button:imagebutton_terrans", imagebutton_terrans);
		this.addRenderableWidget(imagebutton_terrans);
	}
}
