package airbreather.mods.airbreathercore.mod;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class ModBase
{
    private final Main main;

    protected ModBase(Module module)
    {
        checkNotNull(module, "module");
        Injector injector = Guice.createInjector(module);
        this.main = injector.getInstance(Main.class);
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
