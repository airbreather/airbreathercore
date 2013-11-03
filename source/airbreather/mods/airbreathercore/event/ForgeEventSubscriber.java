package airbreather.mods.airbreathercore.event;

import java.util.concurrent.CopyOnWriteArrayList;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.IEventListener;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

// This whole thing is a thin wrapper around the standard Forge event handling system
// to minimize the amount I have to think about global variables and state.
public final class ForgeEventSubscriber implements EventSubscriber
{
    // We might get into a situation where we register a new handler at the same time as we're looping through the
    // existing handlers. It shouldn't happen, but it's easy enough to avoid by using a concurrency-aware collection type,
    // and the negative performance impact shouldn't be a problem because of the expected number and timing of mutations.
    private final CopyOnWriteArrayList<IEventListener> livingDropsEventHandlers = new CopyOnWriteArrayList<IEventListener>();

    public void SubscribeToEvent(EventType eventType, IEventListener handler)
    {
        switch (eventType)
        {
            case LivingDrops:
                this.livingDropsEventHandlers.add(handler);
                break;

            default:
                FMLLog.warning("%s is not a recognized event type.  THIS IS A PROGRAMMING ERROR.", eventType);
                break;
        }
    }

    public void Initialize()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @ForgeSubscribe
    public void OnLivingDropsEvent(LivingDropsEvent event)
    {
        for (IEventListener handler : livingDropsEventHandlers)
        {
            handler.invoke(event);
        }
    }
}
