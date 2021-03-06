package airbreather.mods.airbreathercore.recipe;

import static com.google.common.base.Preconditions.checkNotNull;

// A crafting recipe -- "inputs" come in, ItemStack comes out.
public final class ShapedCraftingRecipe extends Recipe
{
    private final Object[] inputs;

    // TODO: Figure out how to represent inputs more appropriately.
    // This is how the underlying consumers need it, so meh.
    public ShapedCraftingRecipe(RecipeResult result, Object... inputs)
    {
        super(RecipeType.ShapedCrafting, result);
        this.inputs = checkNotNull(inputs, "inputs");
    }

    public Object[] GetInputs()
    {
        return this.inputs;
    }
}
