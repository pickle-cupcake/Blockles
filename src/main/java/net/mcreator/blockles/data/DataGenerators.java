package net.mcreator.blockles.data;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeRecipeProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.mcreator.blockles.BlockFinder;
import net.mcreator.blockles.BlocklesMod;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;

public class DataGenerators {
    public static class RecipeGen extends ForgeRecipeProvider {
        public RecipeGen(DataGenerator generator) {
            super(generator);
        }
    }
    public static class BlockStateGen extends BlockStateProvider {
        public BlockStateGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, BlocklesMod.MODID, existingFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
            for (ResourceLocation i : BlockFinder.woodTypes) {
                createCraftingTable(i);
            }
        }

        public void createCraftingTable(ResourceLocation fromBlock) {
            ConfiguredModel model = new ConfiguredModel(models().withExistingParent()
                .texture(PARTICLE_TAG, texture)
                .texture("top", texture)
                .texture("bottom", texture)
                .texture("side", texture)
                .texture("inside", texture));

            simpleItemBlock(block, model.model);
        }
    }
    public static class ItemModelGen extends ItemModelProvider {
        public ItemModelGen(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, BlocklesMod.MODID, existingFileHelper);
  
        }

        @Override
        protected void registerModels() {
            // TODO Auto-generated method stub
            
        }
    }
}
