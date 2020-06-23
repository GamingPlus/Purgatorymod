package net.mcreator.projectwip.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.projectwip.InbetweendimensionModElements;

@InbetweendimensionModElements.ModElement.Tag
public class PurgatoryDivineRightClickedInAirProcedure extends InbetweendimensionModElements.ModElement {
	public PurgatoryDivineRightClickedInAirProcedure(InbetweendimensionModElements instance) {
		super(instance, 69);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PurgatoryDivineRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PurgatoryDivineRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PurgatoryDivineRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PurgatoryDivineRightClickedInAir!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.DIORITE.getDefaultState(), 3);
	}
}
