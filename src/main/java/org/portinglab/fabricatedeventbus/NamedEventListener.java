package org.portinglab.fabricatedeventbus;

import org.portinglab.fabricatedeventbus.api.Event;
import org.portinglab.fabricatedeventbus.api.EventListenerImpl;

import java.util.function.Supplier;

public class NamedEventListener implements EventListenerImpl {
    public static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("eventbus.namelisteners", "false"));
    static EventListenerImpl namedWrapper(EventListenerImpl listener, Supplier<String> name) {
        if (!DEBUG) return listener;
        return new NamedEventListener(listener, name.get());
    }

    private final EventListenerImpl wrap;
    private final String name;

    public NamedEventListener(EventListenerImpl wrap, final String name) {
        this.wrap = wrap;
        this.name = name;
    }

    @Override
    public String listenerName() {
        return this.name;
    }

    @Override
    public void invoke(final Event event) {
        this.wrap.invoke(event);
    }
}
