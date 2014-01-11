package airbreather.mods.airbreathercore.item;

import net.minecraft.item.Item;

// An interface for classes that can fetch registered items by their definition.
public interface ItemRegistry
{
    // Fetches the actual Item for the given definition.
    Item FetchItem(ItemDefinition itemDefinition);

    // Registers the given definition to map to the given Item.
    void RegisterNewItem(ItemDefinition itemDefinition, Item item);
}
