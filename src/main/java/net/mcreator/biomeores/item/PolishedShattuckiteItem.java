
package net.mcreator.biomeores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.biomeores.procedures.PolishedShattuckiteRightClickedInAirProcedure;
import net.mcreator.biomeores.EnvironmentaloresModElements;

import java.util.Map;
import java.util.HashMap;

@EnvironmentaloresModElements.ModElement.Tag
public class PolishedShattuckiteItem extends EnvironmentaloresModElements.ModElement {
	@ObjectHolder("environmentalores:polished_shattuckite")
	public static final Item block = null;
	public PolishedShattuckiteItem(EnvironmentaloresModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1));
			setRegistryName("polished_shattuckite");
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
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				PolishedShattuckiteRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
