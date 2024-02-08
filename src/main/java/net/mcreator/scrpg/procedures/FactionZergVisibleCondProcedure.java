package net.mcreator.scrpg.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.scrpg.network.ScrpgModVariables;

public class FactionZergVisibleCondProcedure {
	public static boolean execute(LevelAccessor world) {
		if ((ScrpgModVariables.MapVariables.get(world).Faction).equals("zerg")) {
			return true;
		}
		return false;
	}
}
