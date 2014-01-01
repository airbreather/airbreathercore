package airbreather.mods.airbreathercore.item;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

import static com.google.common.base.Preconditions.checkArgument;

// Holds item-related configuration information.
public abstract class ItemConfigurationBase implements ItemConfiguration
{
    private final ImmutableMap<Integer, ItemDefinition> itemMap;

    protected ItemConfigurationBase()
    {
        ImmutableMap.Builder<Integer, ItemDefinition> mapBuilder = ImmutableMap.builder();
        for (ItemDefinition itemDefinition : this.GetItemDefinitionsForBaseItems())
        {
            mapBuilder.put(itemDefinition.GetTag(), itemDefinition);
        }

        for (ItemDefinition itemDefinition : this.GetItemDefinitionsForNewItems())
        {
            mapBuilder.put(itemDefinition.GetTag(), itemDefinition);
        }

        this.itemMap = mapBuilder.build();
    }

    public final ItemDefinition GetItemDefinition(int tag)
    {
        checkArgument(this.itemMap.containsKey(tag),
                      "unrecognized tag: %s... recognized tags are: %s", tag, this.itemMap.keySet());
        return this.itemMap.get(tag);
    }

    public final Iterable<Integer> GetNewItemTags()
    {
        return Iterables.transform(this.GetItemDefinitionsForNewItems(),
                                   new Function<ItemDefinition, Integer>()
                                   {
                                       @Override
                                       public Integer apply(ItemDefinition itemDefinition)
                                       {
                                           return itemDefinition.GetTag();
                                       }
                                   });
    }

    protected abstract Iterable<ItemDefinition> GetItemDefinitionsForNewItems();
    protected abstract Iterable<ItemDefinition> GetItemDefinitionsForBaseItems();
}
