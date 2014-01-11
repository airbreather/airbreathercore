package airbreather.mods.airbreathercore.mod;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.event.EventSubscriber;
import airbreather.mods.airbreathercore.item.ItemRegistrar;
import airbreather.mods.airbreathercore.item.ItemRegistry;
import airbreather.mods.airbreathercore.recipe.RecipeRegistrar;

// Contains all the needed dependencies that one or mods will need.
// Some may be implemented using the null-object pattern.
public interface IModule
{
    EventSubscriber GetEventSubscriber();
    RecipeRegistrar GetRecipeRegistrar();
    ItemRegistry GetItemRegistry();
    ItemRegistrar GetItemRegistrar();
    CustomConfiguration GetCustomConfiguration();
}
