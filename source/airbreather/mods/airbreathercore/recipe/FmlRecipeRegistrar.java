package airbreather.mods.airbreathercore.recipe;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

// Implements RecipeRegistrar using the FML GameRegistry.
public final class FmlRecipeRegistrar implements RecipeRegistrar
{
    // register the given recipes with the underlying system.
    public void RegisterRecipes(Iterable<Recipe> recipes)
    {
        for (Recipe recipe : recipes)
        {
            switch (recipe.GetRecipeType())
            {
                case Smelting:
                    this.RegisterSmeltingRecipe(recipe);
                    break;

                case Crafting:
                    this.RegisterCraftingRecipe(recipe);
                    break;
            }
        }
    }

    private void RegisterSmeltingRecipe(Recipe recipe)
    {
        SmeltingRecipe smeltingRecipe = (SmeltingRecipe)recipe;

        int inputID = smeltingRecipe.GetInput().itemID;
        ItemStack result = smeltingRecipe.GetResult();
        float experience = smeltingRecipe.GetExperience();

        GameRegistry.addSmelting(inputID, result, experience);
    }

    private void RegisterCraftingRecipe(Recipe recipe)
    {
        CraftingRecipe craftingRecipe = (CraftingRecipe)recipe;

        ItemStack result = craftingRecipe.GetResult();
        Object[] inputs = craftingRecipe.GetInputs();

        GameRegistry.addRecipe(result, inputs);
    }
}
