package airbreather.mods.airbreathercore.recipe;

import com.google.common.collect.ImmutableList;

import airbreather.mods.airbreathercore.item.ItemDefinition;

import static com.google.common.base.Preconditions.checkNotNull;

// A crafting recipe -- "inputs" come in, ItemStack comes out.
public final class ShapelessCraftingRecipe extends Recipe
{
    private final ImmutableList<ItemDefinition> inputs;

    public ShapelessCraftingRecipe(RecipeResult result, Iterable<ItemDefinition> inputs)
    {
        super(RecipeType.ShapelessCrafting, result);
        checkNotNull(inputs, "inputs");
        this.inputs = ImmutableList.copyOf(inputs);
    }

    public ImmutableList<ItemDefinition> GetInputs()
    {
        return this.inputs;
    }
}
