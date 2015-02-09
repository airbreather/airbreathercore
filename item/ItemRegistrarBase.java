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

        for (ItemDefinition itemDefinition : configuration.GetItemDefinitionsForNewItems())
        {
            Item item = this.CreateItem(itemDefinition);
            registry.RegisterNewItem(itemDefinition, item);
        }
    }

    protected Item CreateItemCore(ItemDefinition definition)
    {
        checkNotNull(definition, "definition");
        checkArgument(false, "%s is not a recognized item definition.", definition);
        return null;
    }

    private Item CreateItem(ItemDefinition itemDefinition)
    {
        checkNotNull(itemDefinition, "itemDefinition");

        Item item = this.CreateItemCore(itemDefinition);

        String itemName = itemDefinition.GetItemName();
        item.setUnlocalizedName(itemName);

        return item;
    }
}
