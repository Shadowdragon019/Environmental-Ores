package net.mcreator.biomeores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.mcreator.biomeores.block.TourmalineOreSandBlock;
import net.mcreator.biomeores.EnvironmentaloresModElements;

import java.util.Map;
import java.util.HashMap;

@EnvironmentaloresModElements.ModElement.Tag
public class TourmalineOreSandlUpdateTickProcedure extends EnvironmentaloresModElements.ModElement {
	public TourmalineOreSandlUpdateTickProcedure(EnvironmentaloresModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure TourmalineOreSandlUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure TourmalineOreSandlUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure TourmalineOreSandlUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TourmalineOreSandlUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double RandomNumber = 0;
		for (int index0 = 0; index0 < (int) ((((new java.util.Random()).nextInt((int) 5 + 1)) + 1)); index0++) {
			RandomNumber = (double) ((new java.util.Random()).nextInt((int) 5 + 1));
			if (((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:sand_tourmalineible").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock())) && ((RandomNumber) == 0))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), TourmalineOreSandBlock.block.getDefaultState(), 3);
			} else if (((BlockTags.getCollection()
					.getOrCreate(new ResourceLocation(("forge:sand_tourmalineible").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))))).getBlock())) && ((RandomNumber) == 1))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))), TourmalineOreSandBlock.block.getDefaultState(), 3);
			} else if (((BlockTags.getCollection()
					.getOrCreate(new ResourceLocation(("forge:sand_tourmalineible").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock())) && ((RandomNumber) == 2))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), TourmalineOreSandBlock.block.getDefaultState(), 3);
			} else if (((BlockTags.getCollection()
					.getOrCreate(new ResourceLocation(("forge:sand_tourmalineible").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z))).getBlock())) && ((RandomNumber) == 3))) {
				world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z), TourmalineOreSandBlock.block.getDefaultState(), 3);
			} else if (((BlockTags.getCollection()
					.getOrCreate(new ResourceLocation(("forge:sand_tourmalineible").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())) && ((RandomNumber) == 4))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), TourmalineOreSandBlock.block.getDefaultState(), 3);
			} else if (((BlockTags.getCollection()
					.getOrCreate(new ResourceLocation(("forge:sand_tourmalineible").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z))).getBlock())) && ((RandomNumber) == 5))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z), TourmalineOreSandBlock.block.getDefaultState(), 3);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				SpreadTourmalineSpikesProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
