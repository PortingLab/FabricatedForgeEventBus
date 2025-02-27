package org.portinglab.fabricatedeventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.portinglab.fabricatedeventbus.api.EventListenerImpl;

public interface EventListenerFactoryImpl {
    EventListenerImpl create(Method callback, Object target)  throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException;

    default String getUniqueName(Method callback) {
        return String.format("%s.__%s_%s_%s",
            callback.getDeclaringClass().getPackageName(),
            callback.getDeclaringClass().getSimpleName(),
            callback.getName(),
            callback.getParameterTypes()[0].getSimpleName()
        );
    }
}
