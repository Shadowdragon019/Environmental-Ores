
package net.mcreator.biomeores.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.biomeores.EnvironmentaloresModElements;

import java.util.List;
import java.util.Collections;

@EnvironmentaloresModElements.ModElement.Tag
public class TourmalineCrystalBlock extends EnvironmentaloresModElements.ModElement {
	@ObjectHolder("environmentalores:tourmaline_crystal")
	public static final Block block = null;
	public TourmalineCrystalBlock(EnvironmentaloresModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = DirectionalBlock.FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(1f, 1f).lightValue(0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).notSolid());
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("tourmaline_crystal");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vec3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes.create(0.812D, 0.188D, 0.75D, 0.188D, 0.812D, 0D).withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes.create(0.188D, 0.188D, 0.25D, 0.812D, 0.812D, 1D).withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes.create(0.25D, 0.188D, 0.812D, 1D, 0.812D, 0.188D).withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes.create(0.75D, 0.188D, 0.188D, 0D, 0.812D, 0.812D).withOffset(offset.x, offset.y, offset.z);
				case UP :
					return VoxelShapes.create(0.188D, 0.75D, 0.188D, 0.812D, 0D, 0.812D).withOffset(offset.x, offset.y, offset.z);
				case DOWN :
					return VoxelShapes.create(0.188D, 0.25D, 0.812D, 0.812D, 1D, 0.188D).withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(FACING, context.getFace());
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
