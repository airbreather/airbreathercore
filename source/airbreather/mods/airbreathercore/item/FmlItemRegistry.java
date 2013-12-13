package airbreather.mods.airbreathercore.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

// Registers and fetches items using the FML GameRegistry.
public final class FmlItemRegistry implements ItemRegistry
{
    // Fetches the actual Item for the given definition.
    public Item FetchItem(ItemDefinition itemDefinition)
    {
        String itemName = itemDefinition.GetItemName();
        String modID = itemDefinition.GetModID();
        return GameRegistry.findItem(modID, itemName);
    }

    // Registers the given definition to map to the given Item.
    public void RegisterItem(ItemDefinition itemDefinition, Item item)
    {
        String itemName = itemDefinition.GetItemName();
        String modID = itemDefinition.GetModID();

        // This is what I always set them to anyway,
        // so I refuse to sprinkle them all over the code.
        item.setUnlocalizedName(itemName);

        String textureName = String.format("%s:%s", modID, itemName);
        item.setTextureName(textureName);

        GameRegistry.registerItem(item, itemName, modID);
    }
}
