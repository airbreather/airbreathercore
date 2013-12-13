package airbreather.mods.airbreathercore.item;

public final class ItemDefinition
{
    private final Object tag;
    private final int itemID;
    private final String modID;
    private final String itemName;

    public ItemDefinition(Object tag, int itemID, String modID, String itemName)
    {
        this.tag = tag;
        this.itemID = itemID;
        this.modID = modID;
        this.itemName = itemName;
    }

    public Object GetTag()
    {
        return this.tag;
    }

    public int GetItemID()
    {
        return this.itemID;
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