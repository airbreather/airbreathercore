package airbreather.mods.airbreathercore.event;

import net.minecraftforge.event.IEventListener;

// Subscribes events.
public interface EventSubscriber
{
    // Add a handler for the given type of event.
    void SubscribeToEvent(EventType eventType, IEventListener handler);

    // Injects the this into the underlying system's event bus.
    void Initialize();
}
