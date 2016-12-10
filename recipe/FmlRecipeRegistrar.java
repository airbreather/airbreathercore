package airbreather.mods.airbreathercore.recipe;
import com.google.common.collect.ImmutableList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import airbreather.mods.airbreathercore.item.ItemDefinition;
import airbreather.mods.airbreathercore.item.ItemRegistry;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

// Implements RecipeRegistrar using the FML GameRegistry.
public final class FmlRecipeRegistrar implements RecipeRegistrar
{
    // register the given recipes with the underlying system.
    public void RegisterRecipes(RecipeConfiguration recipeConfiguration, ItemRegistry itemRegistry)
    {
        checkNotNull(recipeConfiguration, "recipeConfiguration");
        checkNotNull(itemRegistry, "itemRegistry");

        for (Recipe recipe : recipeConfiguration.GetRecipes())
        {
            switch (recipe.GetRecipeType())
            {
                case Smelting:
                    RegisterSmeltingRecipe(recipe, itemRegistry);
                    break;

                case ShapedCrafting:
                    RegisterShapedCraftingRecipe(recipe, itemRegistry);
                    break;

                case ShapelessCrafting:
                    RegisterShapelessCraftingRecipe(recipe, itemRegistry);
                    break;
            }
        }
    }

    private static void RegisterSmeltingRecipe(Recipe recipe, ItemRegistry itemRegistry)
    {
        checkArgument(recipe instanceof SmeltingRecipe,
                      "recipe must be a SmeltingRecipe, not %s, if GetRecipeType() returns Smelting.",
                      recipe.getClass());

        SmeltingRecipe smeltingRecipe = (SmeltingRecipe)recipe;

        ItemDefinition inputDefinition = smeltingRecipe.GetInput();
        Item input = itemRegistry.FetchItem(inputDefinition);

        RecipeResult result = smeltingRecipe.GetResult();
        ItemStack resultItemStack = GetResultItemStack(result, itemRegistry);

        float experience = smeltingRecipe.GetExperience();

        GameRegistry.addSmelting(input, resultItemStack, experience);
    }

    private static void RegisterShapedCraftingRecipe(Recipe recipe, ItemRegistry itemRegistry)
    {
        checkArgument(recipe instanceof ShapedCraftingRecipe,
                      "recipe must be a ShapedCraftingRecipe, not %s, if GetRecipeType() returns ShapedCrafting.",
                      recipe.getClass());

        ShapedCraftingRecipe shapedCraftingRecipe = (ShapedCraftingRecipe)recipe;

        Object[] inputs = shapedCraftingRecipe.GetInputs().clone();

        // Gotta convert ItemDefinition to their Item.
        for (int i = 0; i < inputs.length; i++)
        {
            Object input = inputs[i];
            if (!(input instanceof ItemDefinition))
            {
                continue;
            }

            ItemDefinition definition = (ItemDefinition)input;
            Item item = itemRegistry.FetchItem(definition);
            inputs[i] = item;
        }

        RecipeResult result = shapedCraftingRecipe.GetResult();
        ItemStack resultItemStack = GetResultItemStack(result, itemRegistry);

        GameRegistry.addRecipe(resultItemStack, inputs);
    }

    private static void RegisterShapelessCraftingRecipe(Recipe recipe, ItemRegistry itemRegistry)
    {
        checkArgument(recipe instanceof ShapelessCraftingRecipe,
                      "recipe must be a ShapelessCraftingRecipe, not %s, if GetRecipeType() returns ShapelessCrafting.",
                      recipe.getClass());

        ShapelessCraftingRecipe shapelessCraftingRecipe = (ShapelessCraftingRecipe)recipe;

        ImmutableList<ItemDefinition> inputDefinitions = shapelessCraftingRecipe.GetInputs();

        // Gotta convert ItemDefinition to their Item.
        Object[] inputs = new Object[inputDefinitions.size()];
        for (int i = 0; i < inputDefinitions.size(); i++)
        {
            ItemDefinition definition = inputDefinitions.get(i);
            Item item = itemRegistry.FetchItem(definition);
            inputs[i] = item;
        }

        RecipeResult result = shapelessCraftingRecipe.GetResult();
        ItemStack resultItemStack = GetResultItemStack(result, itemRegistry);

        GameRegistry.addShapelessRecipe(resultItemStack, inputs);
    }

    private static ItemStack GetResultItemStack(RecipeResult result, ItemRegistry itemRegistry)
    {
        ItemDefinition resultItemDefinition = result.GetItemDefinition();

        Item resultItem = itemRegistry.FetchItem(resultItemDefinition);
        ItemStack resultItemStack = new ItemStack(resultItem);
        int requestedStackSize = Math.max(1, result.GetCount());

        resultItemStack.func_190920_e(Math.min(requestedStackSize, resultItemStack.getMaxStackSize()));
        return resultItemStack;
    }
}
