package org.portinglab.fabricatedeventbus.api;

import org.portinglab.fabricatedeventbus.BusBuilderImpl;

/**
 * Build a bus
 */
public interface BusBuilder {
    public static BusBuilder builder() {
        return new BusBuilderImpl();
    }

    /* true by default */
    BusBuilder setTrackPhases(boolean trackPhases);
    BusBuilder setExceptionHandler(EventExceptionHandlerImpl handler);
    BusBuilder startShutdown();
    BusBuilder checkTypesOnDispatch();
    BusBuilder markerType(Class<?> type);

    /* Use ModLauncher hooks when creating ASM handlers. */
    BusBuilder useModLauncher();

    EventBusImpl build();
}
