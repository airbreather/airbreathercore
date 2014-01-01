package airbreather.mods.airbreathercore.recipe;

import airbreather.mods.airbreathercore.item.ItemDefinition;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

// A smelting recipe -- Item goes in, ItemStack comes out, yielding some experience.
public final class SmeltingRecipe extends Recipe
{
    private final ItemDefinition input;
    private final float experience;

    public SmeltingRecipe(RecipeResult result, ItemDefinition input, float experience)
    {
        super(RecipeType.Smelting, result);
        this.input = checkNotNull(input, "input");
        checkArgument(experience > 0, "experience must be greater than zero, not %s", experience);
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
