package airbreather.mods.airbreathercore.item;

import net.minecraft.item.Item;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class ItemRegistrarBase implements ItemRegistrar
{
    public final void RegisterNewItems(ItemConfiguration configuration, ItemRegistry registry)
    {
        checkNotNull(configuration, "configuration");
        checkNotNull(registry, "registry");

        for (int tag : configuration.GetNewItemTags())
        {
            ItemDefinition itemDefinition = configuration.GetItemDefinition(tag);
            Item item = this.CreateItem(itemDefinition);
            registry.RegisterNewItem(itemDefinition, item);
        }
    }

    protected Item CreateItemCore(ItemDefinition definition)
    {
        checkNotNull(definition, "definition");
        checkArgument(false,
                      "%s is not a recognized item tag (claims to be for %s:%s).",
                      definition.GetTag(),
                      definition.GetModID(),
                      definition.GetItemName());
        return null;
    }

    private Item CreateItem(ItemDefinition itemDefinition)
    {
        checkNotNull(itemDefinition, "itemDefinition");

        Item item = this.CreateItemCore(itemDefinition);

        String itemName = itemDefinition.GetItemName();
        String modID = itemDefinition.GetModID();

        // This is what I always set them to anyway,
        // so I refuse to sprinkle them all over the code.
        item.setUnlocalizedName(itemName);
        String textureName = String.format("%s:%s", modID, itemName);
        item.setTextureName(textureName);

        return item;
    }
}
