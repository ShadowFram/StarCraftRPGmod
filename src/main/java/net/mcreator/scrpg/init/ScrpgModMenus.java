
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scrpg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.scrpg.world.inventory.StarcraftStatsMenu;
import net.mcreator.scrpg.world.inventory.RaceChooseMenu;
import net.mcreator.scrpg.ScrpgMod;

public class ScrpgModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ScrpgMod.MODID);
	public static final RegistryObject<MenuType<StarcraftStatsMenu>> STARCRAFT_STATS = REGISTRY.register("starcraft_stats", () -> IForgeMenuType.create(StarcraftStatsMenu::new));
	public static final RegistryObject<MenuType<RaceChooseMenu>> RACE_CHOOSE = REGISTRY.register("race_choose", () -> IForgeMenuType.create(RaceChooseMenu::new));
}
