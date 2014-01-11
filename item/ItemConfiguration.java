package airbreather.mods.airbreathercore.item;

// An interface for a configuration that can be used to fetch the full ItemDefinition given just its tag.
public interface ItemConfiguration
{
    // Gets the definitions of all the new items configured.
    Iterable<ItemDefinition> GetItemDefinitionsForNewItems();
}
