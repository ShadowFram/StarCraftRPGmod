
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scrpg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.scrpg.block.ZergslimeBlock;
import net.mcreator.scrpg.block.StellBlockBlock;
import net.mcreator.scrpg.block.ProtossMetalBlockBlock;
import net.mcreator.scrpg.block.EnergyBlockBlock;
import net.mcreator.scrpg.block.CreepBlock;
import net.mcreator.scrpg.ScrpgMod;

public class ScrpgModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ScrpgMod.MODID);
	public static final RegistryObject<Block> PROTOSS_METAL_BLOCK = REGISTRY.register("protoss_metal_block", () -> new ProtossMetalBlockBlock());
	public static final RegistryObject<Block> ENERGY_BLOCK = REGISTRY.register("energy_block", () -> new EnergyBlockBlock());
	public static final RegistryObject<Block> ZERGSLIME = REGISTRY.register("zergslime", () -> new ZergslimeBlock());
	public static final RegistryObject<Block> CREEP = REGISTRY.register("creep", () -> new CreepBlock());
	public static final RegistryObject<Block> STELL_BLOCK = REGISTRY.register("stell_block", () -> new StellBlockBlock());
}
