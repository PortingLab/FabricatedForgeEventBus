package org.portinglab.fabricatedeventbus;

import org.portinglab.fabricatedeventbus.api.BusBuilder;
import org.portinglab.fabricatedeventbus.api.Event;
import org.portinglab.fabricatedeventbus.api.EventBusImpl;
import org.portinglab.fabricatedeventbus.api.EventExceptionHandlerImpl;

/**
 * BusBuilder Implementation, public for BusBuilder.builder() only, don't use this directly.
 */
public final class BusBuilderImpl implements BusBuilder {
    EventExceptionHandlerImpl exceptionHandler;
    boolean trackPhases = true;
    boolean startShutdown = false;
    boolean checkTypesOnDispatch = false;
    Class<?> markerType = Event.class;
    boolean modLauncher = false;

    @Override
    public BusBuilder setTrackPhases(boolean trackPhases) {
        this.trackPhases = trackPhases;
        return this;
    }

    @Override
    public BusBuilder setExceptionHandler(EventExceptionHandlerImpl handler) {
        this.exceptionHandler =  handler;
        return this;
    }

    @Override
    public BusBuilder startShutdown() {
        this.startShutdown = true;
        return this;
    }

    @Override
    public BusBuilder checkTypesOnDispatch() {
        this.checkTypesOnDispatch = true;
        return this;
    }

    @Override
    public BusBuilder markerType(Class<?> type) {
        if (!type.isInterface()) throw new IllegalArgumentException("Cannot specify a class marker type");
        this.markerType = type;
        return this;
    }

    @Override
    public BusBuilder useModLauncher() {
        this.modLauncher = true;
        return this;
    }

    @Override
    public EventBusImpl build() {
        return new EventBus(this);
    }
}
