package airbreather.mods.airbreathercore.event;

import net.minecraftforge.fml.common.eventhandler.IEventListener;

// Subscribes events.
public interface EventSubscriber
{
    // Add a handler for the given type of event.
    void SubscribeToEvent(EventType eventType, IEventListener handler);

    // Injects the this into the underlying system's event bus.
    void Initialize();
}
