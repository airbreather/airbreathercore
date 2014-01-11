package airbreather.mods.airbreathercore.item;

import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ItemDefinition
{
    private final String modID;
    private final String itemName;

    public ItemDefinition(String modID, String itemName)
    {
        this.modID = checkNotNull(modID, "modID");
        this.itemName = checkNotNull(itemName, "itemName");
    }

    public String GetModID()
    {
        return this.modID;
    }

    public String GetItemName()
    {
        return this.itemName;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof ItemDefinition))
        {
            return false;
        }

        ItemDefinition other = (ItemDefinition)obj;
        return Objects.equal(this.itemName, other.itemName) &&
               Objects.equal(this.modID, other.modID);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.itemName,
                                this.modID);
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this)
                      .add("itemName", this.itemName)
                      .add("modID", this.modID)
                      .toString();
    }
}
