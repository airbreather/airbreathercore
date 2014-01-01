package airbreather.mods.airbreathercore.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

import static com.google.common.base.Preconditions.checkNotNull;

// Registers and fetches items using the FML GameRegistry.
public final class FmlItemRegistry implements ItemRegistry
{
    // Fetches the actual Item for the given definition.
    public Item FetchItem(ItemDefinition itemDefinition)
    {
        checkNotNull(itemDefinition, "itemDefinition");

        String modID = itemDefinition.GetModID();
        String itemName = itemDefinition.GetItemName();
        return GameRegistry.findItem(modID, itemName);
    }

    // Registers the given definition to map to the given Item.
    public void RegisterNewItem(ItemDefinition itemDefinition, Item item)
    {
        checkNotNull(itemDefinition, "itemDefinition");
        checkNotNull(item, "item");

        String modID = itemDefinition.GetModID();
        String itemName = itemDefinition.GetItemName();

        GameRegistry.registerItem(item, itemName, modID);
    }
}
