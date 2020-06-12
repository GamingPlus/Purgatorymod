
package net.mcreator.projectwip.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.projectwip.itemgroup.SoulTabItemGroup;
import net.mcreator.projectwip.InbetweendimensionModElements;

import java.util.List;

@InbetweendimensionModElements.ModElement.Tag
public class SoulAxeItem extends InbetweendimensionModElements.ModElement {
	@ObjectHolder("inbetweendimension:soul_axe")
	public static final Item block = null;
	public SoulAxeItem(InbetweendimensionModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(SoulTabItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Axe That Can Cut Souls"));
				list.add(new StringTextComponent("And The Dreadless Tree's"));
			}
		}.setRegistryName("soul_axe"));
	}
}
