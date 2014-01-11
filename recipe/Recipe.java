package airbreather.mods.airbreathercore.recipe;

import static com.google.common.base.Preconditions.checkNotNull;

// Base class for all recipes that can be registered using the RecipeRegistrar.
// The RecipeType indicates what kind of a recipe this is (Crafting / Smelting).
public abstract class Recipe
{
    private final RecipeType recipeType;
    private final RecipeResult result;

    protected Recipe(RecipeType recipeType, RecipeResult result)
    {
        this.recipeType = recipeType;
        this.result = checkNotNull(result, "result");
    }

    public final RecipeType GetRecipeType()
    {
        return this.recipeType;
    }

    public final RecipeResult GetResult()
    {
        return this.result;
    }
}
