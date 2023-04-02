package org.portinglab.fabricatedeventbus.api;

public interface EventBusInvokeDispatcherImpl {
    void invoke(EventListenerImpl listener, Event event);
}
