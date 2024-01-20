package net.mcreator.scrpg.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StatstrengthProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		ScrpgModVariables.MapVariables.get(world).strength = ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue();
		ScrpgModVariables.MapVariables.get(world).syncData(world);
		return new java.text.DecimalFormat("##.##").format(ScrpgModVariables.MapVariables.get(world).strength) + "";
	}
}
