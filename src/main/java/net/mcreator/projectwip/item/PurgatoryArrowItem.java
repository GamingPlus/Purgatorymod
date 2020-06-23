
package net.mcreator.projectwip.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.projectwip.procedures.PurgatoryArrowLivingEntityIsHitWithItemProcedure;
import net.mcreator.projectwip.InbetweendimensionModElements;

@InbetweendimensionModElements.ModElement.Tag
public class PurgatoryArrowItem extends InbetweendimensionModElements.ModElement {
	@ObjectHolder("inbetweendimension:purgatory_arrow")
	public static final Item block = null;
	public PurgatoryArrowItem(InbetweendimensionModElements instance) {
		super(instance, 72);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxDamage(23));
			setRegistryName("purgatory_arrow");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			super.hitEntity(itemstack, entity, sourceentity);
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			World world = entity.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				PurgatoryArrowLivingEntityIsHitWithItemProcedure.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
