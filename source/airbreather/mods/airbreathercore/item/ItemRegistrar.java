package airbreather.mods.airbreathercore.item;

// An interface for classes that registers new items in a given ItemConfiguration using a given ItemRegistry.
// Note: this is primarily used as an alternative to having to unseal FmlItemRegistry.
public interface ItemRegistrar
{
    // Registers the new items configured in the given ItemConfiguration using the given ItemRegistry.
    void RegisterNewItems(ItemConfiguration configuration, ItemRegistry registry);
}
