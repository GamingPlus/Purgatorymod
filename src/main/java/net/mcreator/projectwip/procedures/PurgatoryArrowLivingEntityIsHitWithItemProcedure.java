package net.mcreator.projectwip.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.Entity;

import net.mcreator.projectwip.InbetweendimensionModElements;

@InbetweendimensionModElements.ModElement.Tag
public class PurgatoryArrowLivingEntityIsHitWithItemProcedure extends InbetweendimensionModElements.ModElement {
	public PurgatoryArrowLivingEntityIsHitWithItemProcedure(InbetweendimensionModElements instance) {
		super(instance, 72);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PurgatoryArrowLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PurgatoryArrowLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PurgatoryArrowLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PurgatoryArrowLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PurgatoryArrowLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world, (int) x, (int) y, (int) z, false));
		entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 100);
		entity.extinguish();
	}
}
