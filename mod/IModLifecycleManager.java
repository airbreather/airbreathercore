package airbreather.mods.airbreathercore.mod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

// Knows what to do during pre-init, init, and post-init phases.
public interface IModLifecycleManager
{
    void OnPreInit(FMLPreInitializationEvent event);
    void OnInit(FMLInitializationEvent event);
    void OnPostInit(FMLPostInitializationEvent event);
}
