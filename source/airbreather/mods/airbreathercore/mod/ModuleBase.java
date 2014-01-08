package airbreather.mods.airbreathercore.mod;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.CustomConfigurationBase;
import airbreather.mods.airbreathercore.event.EventSubscriber;
import airbreather.mods.airbreathercore.event.ForgeEventSubscriber;
import airbreather.mods.airbreathercore.item.FmlItemRegistry;
import airbreather.mods.airbreathercore.item.ItemRegistrar;
import airbreather.mods.airbreathercore.item.ItemRegistrarBase;
import airbreather.mods.airbreathercore.item.ItemRegistry;
import airbreather.mods.airbreathercore.recipe.FmlRecipeRegistrar;
import airbreather.mods.airbreathercore.recipe.RecipeRegistrar;

public abstract class ModuleBase implements IModule
{
    private final EventSubscriber eventSubscriber = new ForgeEventSubscriber();

    @Override
    public ItemRegistrar GetItemRegistrar() { return new ItemRegistrarBase(); }

    @Override
    public CustomConfiguration GetCustomConfiguration() { return new CustomConfigurationBase(); }

    @Override
    public final EventSubscriber GetEventSubscriber() { return this.eventSubscriber; }
    @Override
    public final RecipeRegistrar GetRecipeRegistrar() { return new FmlRecipeRegistrar(); }
    @Override
    public final ItemRegistry GetItemRegistry() { return new FmlItemRegistry(); }
}
