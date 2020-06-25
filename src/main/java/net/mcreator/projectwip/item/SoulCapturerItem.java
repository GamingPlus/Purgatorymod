
package net.mcreator.projectwip.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.projectwip.procedures.SoulCapsuleBulletHitsLivingEntityProcedure;
import net.mcreator.projectwip.itemgroup.SoulTabItemGroup;
import net.mcreator.projectwip.InbetweendimensionModElements;

import java.util.List;

@InbetweendimensionModElements.ModElement.Tag
public class SoulCapturerItem extends InbetweendimensionModElements.ModElement {
	@ObjectHolder("inbetweendimension:soul_capturer")
	public static final Item block = null;
	public SoulCapturerItem(InbetweendimensionModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SoulTabItemGroup.tab).maxDamage(10));
			setRegistryName("soul_capturer");
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
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Used As Ammo For Soul Capsule"));
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			super.hitEntity(itemstack, entity, sourceentity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			World world = entity.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				SoulCapsuleBulletHitsLivingEntityProcedure.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
