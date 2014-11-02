package airbreather.mods.airbreathercore.event;

// The different kinds of events that we recognize.
public enum EventType
{
    // An entity has died and is being considered for item drops.
    LivingDrops,

    // An entity is being updated this tick.
    LivingUpdate,

    // An entity is being constructed.
    EntityConstructing
}
