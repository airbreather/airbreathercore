package airbreather.mods.airbreathercore.item;

import java.util.ArrayList;

public final class EmptyItemConfiguration implements ItemConfiguration
{
    public Iterable<Integer> GetNewItemTags()
    {
        return new ArrayList<Integer>(0);
    }

    public ItemDefinition GetItemDefinition(int tag)
    {
        return null;
    }
}
