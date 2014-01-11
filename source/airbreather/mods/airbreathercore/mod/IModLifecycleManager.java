package airbreather.mods.airbreathercore.mod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

// Knows what to do during pre-init, init, and post-init phases.
public interface IModLifecycleManager
{
    void OnPreInit(FMLPreInitializationEvent event);
    void OnInit(FMLInitializationEvent event);
    void OnPostInit(FMLPostInitializationEvent event);
}
