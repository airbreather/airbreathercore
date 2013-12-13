package airbreather.mods.airbreathercore.item;

public final class ItemDefinition
{
    private final int tag;
    private final int itemID;
    private final String modID;
    private final String itemName;

    public ItemDefinition(int tag, int itemID, String modID, String itemName)
    {
        this.tag = tag;
        this.itemID = itemID;
        this.modID = modID;
        this.itemName = itemName;
    }

    public int GetTag()
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