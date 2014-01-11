package airbreather.mods.airbreathercore.item;

import com.google.common.collect.ImmutableList;

public final class EmptyItemConfiguration implements ItemConfiguration
{
    @Override
    public Iterable<ItemDefinition> GetItemDefinitionsForNewItems()
    {
        return ImmutableList.of();
    }
}
