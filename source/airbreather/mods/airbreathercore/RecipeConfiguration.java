package airbreather.mods.airbreathercore;

import airbreather.mods.airbreathercore.Recipe;

// An interface for a configuration that holds Recipes configured for this mod.
public interface RecipeConfiguration
{
    // Gets the Recipes configured for this mod.
    Iterable<Recipe> GetRecipes();
}
