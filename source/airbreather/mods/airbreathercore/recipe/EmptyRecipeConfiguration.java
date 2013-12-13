package airbreather.mods.airbreathercore.recipe;

import java.util.ArrayList;

// An interface for a configuration that holds Recipes configured for this mod.
public final class EmptyRecipeConfiguration implements RecipeConfiguration
{
    // Gets the Recipes configured for this mod.
    public Iterable<Recipe> GetRecipes()
    {
        return new ArrayList<Recipe>(0);
    }
}
