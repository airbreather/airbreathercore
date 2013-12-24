package airbreather.mods.airbreathercore.item;

public final class ItemDefinition
{
    private final int tag;
    private final String modID;
    private final String itemName;

    public ItemDefinition(int tag, String modID, String itemName)
    {
        this.tag = tag;
        this.modID = modID;
        this.itemName = itemName;
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