
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scrpg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.scrpg.item.ZergLogoItem;
import net.mcreator.scrpg.item.TerranlogoItem;
import net.mcreator.scrpg.item.ProtosslogoItem;
import net.mcreator.scrpg.ScrpgMod;

public class ScrpgModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ScrpgMod.MODID);
	public static final RegistryObject<Item> TERRANLOGO = REGISTRY.register("terranlogo", () -> new TerranlogoItem());
	public static final RegistryObject<Item> ZERG_LOGO = REGISTRY.register("zerg_logo", () -> new ZergLogoItem());
	public static final RegistryObject<Item> PROTOSSLOGO = REGISTRY.register("protosslogo", () -> new ProtosslogoItem());
}
