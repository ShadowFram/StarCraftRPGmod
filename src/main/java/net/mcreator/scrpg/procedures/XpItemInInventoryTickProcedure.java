package net.mcreator.scrpg.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class XpItemInInventoryTickProcedure {
public static void execute(
Entity entity,
ItemStack itemstack
) {
if(
entity == null
) return ;
itemstack.grow(-1);if (entity instanceof Player _player && !_player.level.isClientSide())
_player.displayClientMessage(Component.literal("+1 XP"), true);if (>) {}
}
}
