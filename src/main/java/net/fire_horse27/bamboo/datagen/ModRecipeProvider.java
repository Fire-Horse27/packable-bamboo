package net.fire_horse27.bamboo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import javax.swing.text.html.HTML;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO, 9)
                        .input(ItemTags.BAMBOO_BLOCKS)
                        .criterion(hasItem(Items.BAMBOO_BLOCK), conditionsFromItem(Items.BAMBOO_BLOCK))
                        .offerTo(exporter, "bamboo:bamboo");

                createShaped(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_PLANKS,4)
                        .pattern("#")
                        .pattern("#")
                        .input('#', ItemTags.BAMBOO_BLOCKS)
                        .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
