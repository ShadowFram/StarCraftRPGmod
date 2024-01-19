
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scrpg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ScrpgModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("scrpg", "protoss"),
				builder -> builder.title(Component.translatable("item_group.scrpg.protoss")).icon(() -> new ItemStack(ScrpgModItems.PROTOSSLOGO.get())).displayItems((parameters, tabData) -> {
					tabData.accept(ScrpgModBlocks.PROTOSS_METAL_BLOCK.get().asItem());
					tabData.accept(ScrpgModBlocks.ENERGY_BLOCK.get().asItem());
				})

		);
	}
}
