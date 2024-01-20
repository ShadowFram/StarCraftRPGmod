package net.mcreator.scrpg.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class LevelProcedure {
	public static String execute() {
		return new java.text.DecimalFormat("##.##").format() + "";
	}
}
