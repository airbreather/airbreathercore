package airbreather.mods.airbreathercore.event;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

import cpw.mods.fml.common.eventhandler.IEventListener;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import static com.google.common.base.Preconditions.checkNotNull;

// This whole thing is a thin wrapper around the standard Forge event handling system
// to minimize the amount I have to think about global variables and state.
public final class ForgeEventSubscriber implements EventSubscriber
{
    private final ListMultimap<EventType, IEventListener> eventListenerMap;

    public ForgeEventSubscriber()
    {
        ListMultimap<EventType, IEventListener> map = LinkedListMultimap.create();
        this.eventListenerMap = Multimaps.synchronizedListMultimap(map);
    }

    public void SubscribeToEvent(EventType eventType, IEventListener handler)
    {
        checkNotNull(handler, "handler");
        this.eventListenerMap.put(eventType, handler);
    }

    public void Initialize()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void OnLivingDropsEvent(LivingDropsEvent event)
    {
        checkNotNull(event, "event");
        for (IEventListener handler : eventListenerMap.get(EventType.LivingDrops))
        {
            handler.invoke(event);
        }
    }
}
