package airbreather.mods.airbreathercore.recipe;

import com.google.common.collect.ImmutableList;

// An interface for a configuration that holds Recipes configured for this mod.
public final class EmptyRecipeConfiguration implements RecipeConfiguration
{
    // Gets the Recipes configured for this mod.
    public Iterable<Recipe> GetRecipes()
    {
        return ImmutableList.of();
    }
}
