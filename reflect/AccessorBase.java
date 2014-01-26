package airbreather.mods.airbreathercore.asm;

import java.lang.reflect.Field;

import com.google.common.base.Optional;

// Base for classes that access non-public members of certain classes.
public class AccessorBase
{
    protected static <T> Optional<T> TryGetField(Object obj, Field field, Class<T> fieldClazz)
    {
        boolean wasAccessible = field.isAccessible();
        if (!wasAccessible)
        {
            try
            {
                field.setAccessible(true);
            }
            catch (SecurityException e)
            {
                return Optional.absent();
            }
        }

        try
        {
            Object valObj = field.get(obj);
            if (!(fieldClazz.isInstance(valObj)))
            {
                return Optional.absent();
            }

            return Optional.of(fieldClazz.cast(valObj));
        }
        catch (IllegalAccessException e)
        {
            return Optional.absent();
        }
        finally
        {
            if (!wasAccessible)
            {
                field.setAccessible(false);
            }
        }
    }
}
