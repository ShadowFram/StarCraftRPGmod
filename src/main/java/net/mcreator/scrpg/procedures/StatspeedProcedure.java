package net.mcreator.scrpg.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StatspeedProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		ScrpgModVariables.MapVariables.get(world).speed = ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue();
		ScrpgModVariables.MapVariables.get(world).syncData(world);
		return new java.text.DecimalFormat("##.##").format(ScrpgModVariables.MapVariables.get(world).speed) + "";
	}
}
