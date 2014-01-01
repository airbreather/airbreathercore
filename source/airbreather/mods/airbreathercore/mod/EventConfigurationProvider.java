package airbreather.mods.airbreathercore.mod;

import com.google.inject.Inject;
import com.google.inject.Provider;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.event.EventConfiguration;

import static com.google.common.base.Preconditions.checkNotNull;

final class EventConfigurationProvider implements Provider<EventConfiguration>
{
    private final CustomConfiguration configuration;

    @Inject
    public EventConfigurationProvider(CustomConfiguration configuration)
    {
        this.configuration = checkNotNull(configuration);
    }

    @Override
    public EventConfiguration get()
    {
        return this.configuration.GetEventConfiguration();
    }
}
