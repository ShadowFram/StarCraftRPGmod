package net.mcreator.scrpg.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.scrpg.network.ScrpgModVariables;

public class PointCounterProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##").format(ScrpgModVariables.MapVariables.get(world).stat_points) + "";
	}
}
