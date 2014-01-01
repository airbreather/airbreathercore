package airbreather.mods.airbreathercore.recipe;

import airbreather.mods.airbreathercore.item.ItemDefinition;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

// The output of a recipe.
public final class RecipeResult
{
    private final ItemDefinition itemDefinition;
    private final int count;

    public RecipeResult(ItemDefinition itemDefinition)
    {
        this(itemDefinition, 1);
    }

    public RecipeResult(ItemDefinition itemDefinition, int count)
    {
        this.itemDefinition = checkNotNull(itemDefinition, "itemDefinition");
        checkArgument(count > 0, "count must be greater than zero, not %s", count);
        this.count = count;
    }

    public ItemDefinition GetItemDefinition()
    {
        return this.itemDefinition;
    }

    public int GetCount()
    {
        return this.count;
    }
}
