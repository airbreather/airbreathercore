package airbreather.mods.airbreathercore;

import airbreather.mods.airbreathercore.Recipe;

// An interface for something that registers recipes.
public interface IRecipeRegistrar
{
    // register the recipes.
    void RegisterRecipes(Iterable<Recipe> recipes);
}
