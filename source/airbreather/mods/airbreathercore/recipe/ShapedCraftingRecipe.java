package airbreather.mods.airbreathercore.recipe;

// A crafting recipe -- "inputs" come in, ItemStack comes out.
public final class CraftingRecipe extends Recipe
{
    private final Object[] inputs;

    // TODO: Figure out how to represent inputs more appropriately.
    // This is how the underlying consumers need it, so meh.
    public CraftingRecipe(RecipeResult result, Object... inputs)
    {
        super(RecipeType.Crafting, result);
        this.inputs = inputs;
    }

    public Object[] GetInputs()
    {
        return this.inputs;
    }
}
