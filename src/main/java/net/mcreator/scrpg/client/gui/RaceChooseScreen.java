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
	ImageButton imagebutton_protosslogo;
	ImageButton imagebutton_zerglogo2;
	ImageButton imagebutton_terranlogo;

	public RaceChooseScreen(RaceChooseMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 308;
		this.imageHeight = 177;
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
		this.blit(ms, this.leftPos + 4, this.topPos + 4, 0, 0, 300, 169, 300, 169);

		RenderSystem.setShaderTexture(0, new ResourceLocation("scrpg:textures/screens/ui_down.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 174, 0, 0, 300, 40, 300, 40);

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
		imagebutton_protosslogo = new ImageButton(this.leftPos + 9, this.topPos + 175, 105, 32, 0, 0, 32, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_protosslogo.png"), 105, 64, e -> {
			if (true) {
				ScrpgMod.PACKET_HANDLER.sendToServer(new RaceChooseButtonMessage(0, x, y, z));
				RaceChooseButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_protosslogo", imagebutton_protosslogo);
		this.addRenderableWidget(imagebutton_protosslogo);
		imagebutton_zerglogo2 = new ImageButton(this.leftPos + 109, this.topPos + 176, 98, 32, 0, 0, 32, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_zerglogo2.png"), 98, 64, e -> {
			if (true) {
				ScrpgMod.PACKET_HANDLER.sendToServer(new RaceChooseButtonMessage(1, x, y, z));
				RaceChooseButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_zerglogo2", imagebutton_zerglogo2);
		this.addRenderableWidget(imagebutton_zerglogo2);
		imagebutton_terranlogo = new ImageButton(this.leftPos + 203, this.topPos + 174, 98, 32, 0, 0, 32, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_terranlogo.png"), 98, 64, e -> {
			if (true) {
				ScrpgMod.PACKET_HANDLER.sendToServer(new RaceChooseButtonMessage(2, x, y, z));
				RaceChooseButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_terranlogo", imagebutton_terranlogo);
		this.addRenderableWidget(imagebutton_terranlogo);
	}
}
