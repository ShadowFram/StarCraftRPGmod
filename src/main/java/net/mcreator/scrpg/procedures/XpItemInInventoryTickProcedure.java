package net.mcreator.scrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.scrpg.network.ScrpgModVariables;

public class XpItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.grow(-1);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("+1 XP"), true);
		ScrpgModVariables.MapVariables.get(world).stat_XP = ScrpgModVariables.MapVariables.get(world).stat_XP + 1;
		ScrpgModVariables.MapVariables.get(world).syncData(world);
		ScrpgModVariables.MapVariables.get(world).LevelCond = ScrpgModVariables.MapVariables.get(world).stat_Level * 2.5;
		ScrpgModVariables.MapVariables.get(world).syncData(world);
		if (ScrpgModVariables.MapVariables.get(world).stat_XP > ScrpgModVariables.MapVariables.get(world).LevelCond) {
			ScrpgModVariables.MapVariables.get(world).stat_XP = ScrpgModVariables.MapVariables.get(world).LevelCond / 2.5 - ScrpgModVariables.MapVariables.get(world).stat_XP;
			ScrpgModVariables.MapVariables.get(world).syncData(world);
			ScrpgModVariables.MapVariables.get(world).stat_Level = ScrpgModVariables.MapVariables.get(world).stat_Level + 1;
			ScrpgModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
