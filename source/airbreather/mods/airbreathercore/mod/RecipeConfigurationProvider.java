package airbreather.mods.airbreathercore.mod;

import com.google.inject.Inject;
import com.google.inject.Provider;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;

import static com.google.common.base.Preconditions.checkNotNull;

final class RecipeConfigurationProvider implements Provider<RecipeConfiguration>
{
    private final CustomConfiguration configuration;

    @Inject
    public RecipeConfigurationProvider(CustomConfiguration configuration)
    {
        this.configuration = checkNotNull(configuration);
    }

    @Override
    public RecipeConfiguration get()
    {
        return this.configuration.GetRecipeConfiguration();
    }
}
