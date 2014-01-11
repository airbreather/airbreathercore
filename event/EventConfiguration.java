package airbreather.mods.airbreathercore.event;

import cpw.mods.fml.common.eventhandler.IEventListener;

// An interface for a configuration that holds the event handlers configured to use for this mod.
public interface EventConfiguration
{
    // Gets all the event types recognized by this configuration.
    Iterable<EventType> GetRecognizedEventTypes();

    // Gets all the handlers for this listener of a particular event type.
    Iterable<IEventListener> GetEventHandlers(EventType eventType);
}
