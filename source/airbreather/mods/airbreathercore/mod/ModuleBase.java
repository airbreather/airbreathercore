package airbreather.mods.airbreathercore.mod;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import airbreather.mods.airbreathercore.event.EventSubscriber;
import airbreather.mods.airbreathercore.event.ForgeEventSubscriber;
import airbreather.mods.airbreathercore.item.FmlItemRegistry;
import airbreather.mods.airbreathercore.item.ItemRegistry;
import airbreather.mods.airbreathercore.recipe.FmlRecipeRegistrar;
import airbreather.mods.airbreathercore.recipe.RecipeRegistrar;

public class ModuleBase extends AbstractModule
{
    @Override
    protected void configure()
    {
        this.bind(EventSubscriber.class).to(ForgeEventSubscriber.class).in(Scopes.SINGLETON);
        this.bind(RecipeRegistrar.class).to(FmlRecipeRegistrar.class);
        this.bind(ItemRegistry.class).to(FmlItemRegistry.class);
    }
}
