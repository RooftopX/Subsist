package net.mcreator.subsist.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class HellstoneFurnaceUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		HellstoneCookRecipeProcedure.execute(world, x, y, z, entity);
	}
}
