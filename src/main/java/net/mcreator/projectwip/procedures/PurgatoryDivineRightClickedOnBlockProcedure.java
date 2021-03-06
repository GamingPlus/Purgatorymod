package net.mcreator.projectwip.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.projectwip.block.SoulBlockBlock;
import net.mcreator.projectwip.InbetweendimensionModElements;

@InbetweendimensionModElements.ModElement.Tag
public class PurgatoryDivineRightClickedOnBlockProcedure extends InbetweendimensionModElements.ModElement {
	public PurgatoryDivineRightClickedOnBlockProcedure(InbetweendimensionModElements instance) {
		super(instance, 66);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PurgatoryDivineRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PurgatoryDivineRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PurgatoryDivineRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PurgatoryDivineRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Blocks.WATER.getDefaultState().getMaterial() == net.minecraft.block.material.Material.WATER)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SoulBlockBlock.block.getDefaultState(), 3);
		}
	}
}
