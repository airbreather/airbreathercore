package airbreather.mods.airbreathercore.recipe;

import airbreather.mods.airbreathercore.item.ItemRegistry;

// An interface for something that registers recipes.
public interface RecipeRegistrar
{
    // register the configured recipes, using the given ItemRegistry to look up items.
    void RegisterRecipes(RecipeConfiguration recipeConfiguration, ItemRegistry itemRegistry);
}
