package airbreather.mods.airbreathercore;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import airbreather.mods.airbreathercore.Recipe;
import airbreather.mods.airbreathercore.CraftingRecipe;
import airbreather.mods.airbreathercore.SmeltingRecipe;

// Implements IRecipeRegistrar using the FML GameRegistry.
public final class RecipeRegistrar implements IRecipeRegistrar
{
    // register the recipes for this mod.
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
