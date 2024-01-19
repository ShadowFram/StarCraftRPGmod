package net.mcreator.scrpg.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.scrpg.network.ScrpgModVariables;

public class StrengthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##.##").format((entity.getCapability(ScrpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ScrpgModVariables.PlayerVariables())).strength) + "";
	}
}
