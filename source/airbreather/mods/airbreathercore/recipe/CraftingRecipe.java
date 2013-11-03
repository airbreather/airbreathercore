package airbreather.mods.airbreathercore.recipe;

import net.minecraft.item.ItemStack;

// A crafting recipe -- "inputs" come in, ItemStack comes out.
public final class CraftingRecipe extends Recipe
{
    private final ItemStack result;
    private final Object[] inputs;

    // TODO: Figure out how to represent inputs more appropriately.
    // This is how the underlying consumers need it, so meh.
    public CraftingRecipe(ItemStack result, Object... inputs)
    {
        super(RecipeType.Crafting);
        this.result = result;
        this.inputs = inputs;
    }

    public ItemStack GetResult()
    {
        return this.result;
    }

    public Object[] GetInputs()
    {
        return this.inputs;
    }
}
