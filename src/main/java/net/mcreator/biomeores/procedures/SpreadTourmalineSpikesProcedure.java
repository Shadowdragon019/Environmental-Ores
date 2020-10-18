package net.mcreator.biomeores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.biomeores.block.TourmalineCrystalBlock;
import net.mcreator.biomeores.EnvironmentaloresModElements;

import java.util.Map;

@EnvironmentaloresModElements.ModElement.Tag
public class SpreadTourmalineSpikesProcedure extends EnvironmentaloresModElements.ModElement {
	public SpreadTourmalineSpikesProcedure(EnvironmentaloresModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SpreadTourmalineSpikes!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SpreadTourmalineSpikes!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SpreadTourmalineSpikes!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SpreadTourmalineSpikes!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double RandomNumber = 0;
		RandomNumber = (double) ((new java.util.Random()).nextInt((int) 5 + 1));
		if (((world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z + 1)))) && ((RandomNumber) == 0))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), TourmalineCrystalBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)));
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.SOUTH), 3);
			} catch (Exception e) {
			}
		} else if (((world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z + (-1))))) && ((RandomNumber) == 1))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))), TourmalineCrystalBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))));
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.NORTH), 3);
			} catch (Exception e) {
			}
		} else if (((world.isAirBlock(new BlockPos((int) (x + 1), (int) y, (int) z))) && ((RandomNumber) == 2))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), TourmalineCrystalBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z));
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
			} catch (Exception e) {
			}
		} else if (((world.isAirBlock(new BlockPos((int) (x + (-1)), (int) y, (int) z))) && ((RandomNumber) == 3))) {
			world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z), TourmalineCrystalBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z));
				world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
			} catch (Exception e) {
			}
		} else if (((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))) && ((RandomNumber) == 4))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), TourmalineCrystalBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.UP), 3);
			} catch (Exception e) {
			}
		} else if (((world.isAirBlock(new BlockPos((int) x, (int) (y + (-1)), (int) z))) && ((RandomNumber) == 5))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z), TourmalineCrystalBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z));
				world.setBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.DOWN), 3);
			} catch (Exception e) {
			}
		}
	}
}
