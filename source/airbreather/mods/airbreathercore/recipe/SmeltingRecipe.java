package airbreather.mods.airbreathercore.recipe;

import airbreather.mods.airbreathercore.item.ItemDefinition;

// A smelting recipe -- Item goes in, ItemStack comes out, yielding some experience.
public final class SmeltingRecipe extends Recipe
{
    private final ItemDefinition input;
    private final float experience;

    public SmeltingRecipe(RecipeResult result, ItemDefinition input, float experience)
    {
        super(RecipeType.Smelting, result);
        this.input = input;
        this.experience = experience;
    }

    public ItemDefinition GetInput()
    {
        return this.input;
    }

    public float GetExperience()
    {
        return this.experience;
    }
}
