package airbreather.mods.airbreathercore;

import java.io.File;

import airbreather.mods.airbreathercore.event.EventConfiguration;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;

// Interface for mod configurations.
public interface CustomConfiguration
{
    // Initializes the configuration from a file.
    // TODO: If I ever care enough to write unit tests, make this mockable.
    void Initialize(File configurationFile);

    // Gets the ItemConfiguration object that maps arbitrary internal IDs to Item objects that this mod uses.
    ItemConfiguration GetItemConfiguration();

    // Gets the RecipeConfiguration object that is used to fetch the recipes configured for this mod.
    RecipeConfiguration GetRecipeConfiguration();

    // Gets the EventConfiguration object that is used to fetch the events configured for this mod to handle.
    EventConfiguration GetEventConfiguration();
}
