package airbreather.mods.airbreathercore.item;

// An interface for a configuration that can be used to fetch the full ItemDefinition given just its tag.
public interface ItemConfiguration
{
    // Gets the full ItemDefinition configured for a given tag.
    ItemDefinition GetItemDefinition(Object tag);
}
