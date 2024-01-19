package net.mcreator.scrpg.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.scrpg.network.ScrpgModVariables;

public class StrengthProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		{
			double _setval = ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue();
			entity.getCapability(ScrpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.strength = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		return new java.text.DecimalFormat("##.##").format((entity.getCapability(ScrpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ScrpgModVariables.PlayerVariables())).strength) + "";
	}
}
