package net.mcreator.projectwip.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.projectwip.item.TheInbetweenItem;
import net.mcreator.projectwip.InbetweendimensionModElements;

@InbetweendimensionModElements.ModElement.Tag
public class IgniterItemIsCraftedsmeltedProcedure extends InbetweendimensionModElements.ModElement {
	public IgniterItemIsCraftedsmeltedProcedure(InbetweendimensionModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure IgniterItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			ItemStack _isc = (itemstack);
			final ItemStack _setstack = new ItemStack(TheInbetweenItem.block, (int) (1));
			final int _sltid = (int) (0);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		Entity entity = event.getPlayer();
		World world = entity.world;
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;
		ItemStack itemStack = event.getCrafting();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("itemstack", itemStack);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
