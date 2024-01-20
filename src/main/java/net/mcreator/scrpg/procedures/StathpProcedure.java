package net.mcreator.scrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.scrpg.network.ScrpgModVariables;

public class StathpProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##.##").format(ScrpgModVariables.MapVariables.get(world).hp) + "";
	}
}
