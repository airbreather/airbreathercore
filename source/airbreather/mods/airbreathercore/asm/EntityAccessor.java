package airbreather.mods.airbreathercore.asm;

import java.lang.reflect.Field;
import java.util.Random;

import com.google.common.base.Optional;

import net.minecraft.entity.Entity;

// Provides methods that help get at non-public members of Entity.
public final class EntityAccessor extends AccessorBase
{
    private static final Optional<Field> randField;
    private final Entity entity;

    public EntityAccessor(Entity entity)
    {
        this.entity = entity;
    }

    public Optional<Random> GetRand()
    {
        if (!randField.isPresent())
        {
            return Optional.absent();
        }

        synchronized(randField)
        {
            return TryGetField(this.entity, randField.get(), Random.class);
        }
    }

    static
    {
        // FD: qn/aa net/minecraft/entity/Entity/field_70146_Z
        // field_70146_Z,rand,2,
        final String randSrgName = "field_70146_Z";
        Optional<Field> f;
        try
        {
            f = Optional.of(Entity.class.getDeclaredField(randSrgName));
        }
        catch (NoSuchFieldException e)
        {
            f = Optional.absent();
        }

        randField = f;
    }
}
