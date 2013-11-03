package airbreather.mods.airbreathercore.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// A smelting recipe -- Item goes in, ItemStack comes out, yielding some experience.
public final class SmeltingRecipe extends Recipe
{
    private final ItemStack result;
    private final Item input;
    private final float experience;

    public SmeltingRecipe(ItemStack result, Item input, float experience)
    {
        super(RecipeType.Smelting);
        this.result = result;
        this.input = input;
        this.experience = experience;
    }

    public ItemStack GetResult()
    {
        return this.result;
    }

    public Item GetInput()
    {
        return this.input;
    }

    public float GetExperience()
    {
        return this.experience;
    }
}
