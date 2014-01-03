package airbreather.mods.airbreathercore.mod;

import com.google.inject.Inject;
import com.google.inject.Provider;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.item.ItemConfiguration;

import static com.google.common.base.Preconditions.checkNotNull;

final class ItemConfigurationProvider implements Provider<ItemConfiguration>
{
    private final CustomConfiguration configuration;

    @Inject
    public ItemConfigurationProvider(CustomConfiguration configuration)
    {
        this.configuration = checkNotNull(configuration, "configuration");
    }

    @Override
    public ItemConfiguration get()
    {
        return this.configuration.GetItemConfiguration();
    }
}
