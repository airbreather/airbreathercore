package airbreather.mods.airbreathercore.mod;

import java.io.File;

import com.google.inject.Inject;

import cpw.mods.fml.common.eventhandler.IEventListener;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.event.EventConfiguration;
import airbreather.mods.airbreathercore.event.EventSubscriber;
import airbreather.mods.airbreathercore.event.EventType;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemRegistrar;
import airbreather.mods.airbreathercore.item.ItemRegistry;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeRegistrar;

import static com.google.common.base.Preconditions.checkNotNull;

final class Main
{
    // The dependencies used to delegate specific mod responsibilities.
    private final ItemRegistry itemRegistry;
    private final ItemRegistrar itemRegistrar;
    private final RecipeRegistrar recipeRegistrar;
    private final EventSubscriber eventSubscriber;
    private final CustomConfiguration configuration;

    @Inject
    public Main(final ItemRegistry itemRegistry,
                final ItemRegistrar itemRegistrar,
                final RecipeRegistrar recipeRegistrar,
                final EventSubscriber eventSubscriber,
                final CustomConfiguration configuration)
    {
        this.itemRegistry = checkNotNull(itemRegistry, "itemRegistry");
        this.itemRegistrar = checkNotNull(itemRegistrar, "itemRegistrar");
        this.recipeRegistrar = checkNotNull(recipeRegistrar, "recipeRegistrar");
        this.eventSubscriber = checkNotNull(eventSubscriber, "eventSubscriber");
        this.configuration = checkNotNull(configuration, "configuration");
    }

    public void preInit(File configurationFile)
    {
        checkNotNull(configurationFile, "configurationFile");
        this.configuration.Initialize(configurationFile);

        ItemConfiguration itemConfiguration = this.configuration.GetItemConfiguration();
        this.itemRegistrar.RegisterNewItems(itemConfiguration, this.itemRegistry);
    }

    public void postInit()
    {
        // Register all the recipes.
        // This MUST be called during post-initialization, or else FmlItemRegistry won't have any items yet.
        RecipeConfiguration recipeConfiguration = this.configuration.GetRecipeConfiguration();
        this.recipeRegistrar.RegisterRecipes(recipeConfiguration, this.itemRegistry);

        // Now register all the event handlers, particularly those for mob drop events.
        this.eventSubscriber.Initialize();
        EventConfiguration eventConfiguration = this.configuration.GetEventConfiguration();
        for (EventType eventType : eventConfiguration.GetRecognizedEventTypes())
        {
            for (IEventListener handler : eventConfiguration.GetEventHandlers(eventType))
            {
                this.eventSubscriber.SubscribeToEvent(eventType, handler);
            }
        }
    }
}
