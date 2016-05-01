package airbreather.mods.airbreathercore.event;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.IEventListener;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.google.common.base.Preconditions.checkNotNull;

// This whole thing is a thin wrapper around the standard Forge event handling system
// to minimize the amount I have to think about global variables and state.
public final class ForgeEventSubscriber implements EventSubscriber
{
    private final ListMultimap<EventType, IEventListener> eventListenerMap;

    public ForgeEventSubscriber()
    {
        this.eventListenerMap = ArrayListMultimap.create();
    }

    @Override
    public void SubscribeToEvent(EventType eventType, IEventListener handler)
    {
        checkNotNull(handler, "handler");
        synchronized(this.eventListenerMap)
        {
            this.eventListenerMap.put(eventType, handler);
        }
    }

    @Override
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

    @SubscribeEvent
    public void OnLivingUpdateEvent(LivingUpdateEvent event)
    {
        checkNotNull(event, "event");
        for (IEventListener handler : eventListenerMap.get(EventType.LivingUpdate))
        {
            handler.invoke(event);
        }
    }

    @SubscribeEvent
    public void OnEntityConstructingEvent(EntityConstructing event)
    {
        checkNotNull(event, "event");
        for (IEventListener handler : eventListenerMap.get(EventType.EntityConstructing))
        {
            handler.invoke(event);
        }
    }
}
