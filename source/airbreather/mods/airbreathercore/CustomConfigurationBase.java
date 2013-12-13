package airbreather.mods.airbreathercore;

import java.io.File;
import airbreather.mods.airbreathercore.event.EmptyEventConfiguration;
import airbreather.mods.airbreathercore.event.EventConfiguration;
import airbreather.mods.airbreathercore.item.EmptyItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.recipe.EmptyRecipeConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;

public abstract class CustomConfigurationBase implements CustomConfiguration
{
    public abstract void Initialize(File configurationFile);

    public ItemConfiguration GetItemConfiguration()
    {
        return new EmptyItemConfiguration();
    }

    public RecipeConfiguration GetRecipeConfiguration()
    {
        return new EmptyRecipeConfiguration();
    }

    public EventConfiguration GetEventConfiguration()
    {
        return new EmptyEventConfiguration();
    }
}
