package airbreather.mods.airbreathercore.recipe;

// An interface for something that registers recipes.
public interface RecipeRegistrar
{
    // register the recipes.
    void RegisterRecipes(Iterable<Recipe> recipes);
}
