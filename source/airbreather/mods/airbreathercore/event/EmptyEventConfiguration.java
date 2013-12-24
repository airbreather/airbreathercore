package airbreather.mods.airbreathercore.event;

import java.util.ArrayList;
import cpw.mods.fml.common.eventhandler.IEventListener;

public final class EmptyEventConfiguration implements EventConfiguration
{
    // Gets all the event types recognized by this configuration.
    public Iterable<EventType> GetRecognizedEventTypes()
    {
        return new ArrayList<EventType>(0);
    }

    // Gets all the handlers for this listener of a particular event type.
    public Iterable<IEventListener> GetEventHandlers(EventType eventType)
    {
        return new ArrayList<IEventListener>(0);
    }
}
