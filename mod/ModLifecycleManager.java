package airbreather.mods.airbreathercore.mod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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

// Performs all the standard mod registration stuff needed
// during pre-init, init, and post-init.
public final class ModLifecycleManager implements IModLifecycleManager
{
    // The dependencies used to delegate specific mod responsibilities.
    private final ItemRegistry itemRegistry;
    private final ItemRegistrar itemRegistrar;
    private final RecipeRegistrar recipeRegistrar;
    private final EventSubscriber eventSubscriber;
    private final CustomConfiguration configuration;

    public ModLifecycleManager(IModule module)
    {
        checkNotNull(module, "module");

        this.itemRegistry = module.GetItemRegistry();
        this.itemRegistrar = module.GetItemRegistrar();
        this.recipeRegistrar = module.GetRecipeRegistrar();
        this.eventSubscriber = module.GetEventSubscriber();
        this.configuration = module.GetCustomConfiguration();
    }

    @Override
    public void OnPreInit(FMLPreInitializationEvent event)
    {
        checkNotNull(event, "event");
        this.configuration.Initialize(event.getSuggestedConfigurationFile());

        // Register all the new items
        // (do this before registering the things that may depend on them)
        ItemConfiguration itemConfiguration = this.configuration.GetItemConfiguration();
        this.itemRegistrar.RegisterNewItems(itemConfiguration, this.itemRegistry);

        // Register all the recipes.
        RecipeConfiguration recipeConfiguration = this.configuration.GetRecipeConfiguration();
        this.recipeRegistrar.RegisterRecipes(recipeConfiguration, this.itemRegistry);

        // Register all the event handlers.
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

    @Override
    public void OnInit(FMLInitializationEvent event)
    {
        checkNotNull(event, "event");
    }

    @Override
    public void OnPostInit(FMLPostInitializationEvent event)
    {
        checkNotNull(event, "event");
    }
}
