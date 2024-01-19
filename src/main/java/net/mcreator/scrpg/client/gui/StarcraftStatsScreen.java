package net.mcreator.scrpg.client.gui;

public class StarcraftStatsScreen extends AbstractContainerScreen<StarcraftStatsMenu> {

	private final static HashMap<String, Object> guistate = StarcraftStatsMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

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
		this.font.draw(poseStack, Component.translatable("gui.scrpg.starcraft_stats.label_varbolean"), 6, 6, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();

		imagebutton_zergicon_gui_basic = new ImageButton(this.leftPos + -31, this.topPos + 4, 32, 32, 0, 0, 32, new ResourceLocation("scrpg:textures/screens/atlas/imagebutton_zergicon_gui_basic.png"), 32, 64, e -> {
		});

		guistate.put("button:imagebutton_zergicon_gui_basic", imagebutton_zergicon_gui_basic);
		this.addRenderableWidget(imagebutton_zergicon_gui_basic);

	}

}
