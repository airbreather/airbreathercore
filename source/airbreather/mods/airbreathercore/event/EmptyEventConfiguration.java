package airbreather.mods.airbreathercore.event;

import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.eventhandler.IEventListener;

public final class EmptyEventConfiguration implements EventConfiguration
{
    // Gets all the event types recognized by this configuration.
    @Override
    public Iterable<EventType> GetRecognizedEventTypes()
    {
        return ImmutableList.of();
    }

    // Gets all the handlers for this listener of a particular event type.
    @Override
    public Iterable<IEventListener> GetEventHandlers(EventType eventType)
    {
        return ImmutableList.of();
    }
}
