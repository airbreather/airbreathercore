package airbreather.mods.airbreathercore.mod;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class ModBase
{
    private final Main main;

    protected ModBase(IModule module)
    {
        checkNotNull(module, "module");
        this.main = new Main(module.GetItemRegistry(),
                             module.GetItemRegistrar(),
                             module.GetRecipeRegistrar(),
                             module.GetEventSubscriber(),
                             module.GetCustomConfiguration());
    }

    protected void preInitCore(FMLPreInitializationEvent event)
    {
        checkNotNull(event, "event");
        this.main.preInit(event.getSuggestedConfigurationFile());
    }

    protected void postInitCore(FMLPostInitializationEvent event)
    {
        checkNotNull(event, "event");
        this.main.postInit();
    }
}
