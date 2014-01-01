package airbreather.mods.airbreathercore.item;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ItemDefinition
{
    private final int tag;
    private final String modID;
    private final String itemName;

    public ItemDefinition(int tag, String modID, String itemName)
    {
        this.tag = tag;
        this.modID = checkNotNull(modID, "modID");
        this.itemName = checkNotNull(itemName, "itemName");
    }

    public int GetTag()
    {
        return this.tag;
    }

    public String GetModID()
    {
        return this.modID;
    }

    public String GetItemName()
    {
        return this.itemName;
    }
}