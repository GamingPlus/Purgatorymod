package net.mcreator.projectwip.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.Entity;

import net.mcreator.projectwip.item.GoodSoulItem;
import net.mcreator.projectwip.item.BadSoulItem;
import net.mcreator.projectwip.InbetweendimensionModElements;

@InbetweendimensionModElements.ModElement.Tag
public class SoulCapsuleBulletHitsLivingEntityProcedure extends InbetweendimensionModElements.ModElement {
	public SoulCapsuleBulletHitsLivingEntityProcedure(InbetweendimensionModElements instance) {
		super(instance, 56);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SoulCapsuleBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure SoulCapsuleBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((entity instanceof AnimalEntity)) {
			if ((Math.random() < 0.4)) {
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GoodSoulItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
				}
			}
			if ((entity instanceof MonsterEntity)) {
				if ((Math.random() < 0.4)) {
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(BadSoulItem.block, (int) (1));
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
				}
			}
		}
	}
}
