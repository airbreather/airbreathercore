package airbreather.mods.airbreathercore.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import airbreather.mods.airbreathercore.item.ItemDefinition;

import static com.google.common.base.Preconditions.checkNotNull;

// This is a hack to get *something* up and running for 1.8 stuff.
final class HackTextureRegistry
{
    public static void RegisterTexture(ItemDefinition itemDefinition, Item item)
    {
        checkNotNull(itemDefinition, "itemDefinition");
        checkNotNull(item, "item");

        String textureName = String.format("%s:%s", itemDefinition.GetModID(), itemDefinition.GetItemName());

        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(textureName, "inventory"));
    }
}
