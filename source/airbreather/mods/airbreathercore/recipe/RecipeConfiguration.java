package airbreather.mods.airbreathercore.recipe;

// An interface for a configuration that holds Recipes configured for this mod.
public interface RecipeConfiguration
{
    // Gets the Recipes configured for this mod.
    Iterable<Recipe> GetRecipes();
}
