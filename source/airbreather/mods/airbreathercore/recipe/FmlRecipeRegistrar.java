package airbreather.mods.airbreathercore.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import airbreather.mods.airbreathercore.item.ItemDefinition;
import airbreather.mods.airbreathercore.item.ItemRegistry;

// Implements RecipeRegistrar using the FML GameRegistry.
public final class FmlRecipeRegistrar implements RecipeRegistrar
{
    private final ItemRegistry itemRegistry;

    public FmlRecipeRegistrar(ItemRegistry itemRegistry)
    {
        this.itemRegistry = itemRegistry;
    }

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

                case ShapedCrafting:
                    this.RegisterShapedCraftingRecipe(recipe);
                    break;
            }
        }
    }

    private void RegisterSmeltingRecipe(Recipe recipe)
    {
        SmeltingRecipe smeltingRecipe = (SmeltingRecipe)recipe;

        ItemDefinition input = smeltingRecipe.GetInput();

        RecipeResult result = smeltingRecipe.GetResult();
        ItemStack resultItemStack = this.GetResultItemStack(result);

        int inputID = input.GetItemID();
        float experience = smeltingRecipe.GetExperience();

        GameRegistry.addSmelting(inputID, resultItemStack, experience);
    }

    private void RegisterShapedCraftingRecipe(Recipe recipe)
    {
        ShapedCraftingRecipe shapedCraftingRecipe = (ShapedCraftingRecipe)recipe;

        Object[] inputs = shapedCraftingRecipe.GetInputs();

        RecipeResult result = shapedCraftingRecipe.GetResult();
        ItemStack resultItemStack = this.GetResultItemStack(result);

        GameRegistry.addRecipe(resultItemStack, inputs);
    }

    private ItemStack GetResultItemStack(RecipeResult result)
    {
        ItemDefinition resultItemDefinition = result.GetItemDefinition();

        Item resultItem = this.itemRegistry.FetchItem(resultItemDefinition);
        ItemStack resultItemStack = new ItemStack(resultItem);
        int requestedStackSize = Math.max(1, result.GetCount());

        resultItemStack.stackSize = Math.min(requestedStackSize, resultItemStack.getMaxStackSize());
        return resultItemStack;
    }
}
