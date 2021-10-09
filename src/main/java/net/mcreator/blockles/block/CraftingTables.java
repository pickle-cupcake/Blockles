
package net.mcreator.blockles.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.Block;
import net.mcreator.blockles.BlockFinder;
import net.mcreator.blockles.BlocklesModElements;
import net.minecraftforge.common.data.ForgeRecipeProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;

import java.util.List;
import java.util.Collections;

@BlocklesModElements.ModElement.Tag
public class CraftingTables extends BlocklesModElements.ModElement {
	@ObjectHolder("blockles:crafting_tables")
	public static final Block block = null;
	public CraftingTables(BlocklesModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		for (ResourceLocation i : BlockFinder.woodTypes) {
	    	elements.blocks.add(() -> new CustomBlock(i.getPath()));
	    	elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
		}
	}
	public static class CustomBlock extends CraftingTableBlock {
		public CustomBlock(String woodName) {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));
			setRegistryName("crafting_tables." + woodName);
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}
	}
}
