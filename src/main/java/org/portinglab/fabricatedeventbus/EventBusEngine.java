package org.portinglab.fabricatedeventbus;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

public final class EventBusEngine implements EventBusEngineImpl {
    private final EventSubclassTransformer eventTransformer;
    private final EventAccessTransformer accessTransformer;
    final String EVENT_CLASS = "org.portinglab.fabricatedeventbus.api.Event";

    public EventBusEngine() {
        FabricatedForgeEventBus.LOGGER.debug(FabricatedForgeEventBus.EVENTBUS_MARKER, "Loading EventBus transformers");
        this.eventTransformer = new EventSubclassTransformer();
        this.accessTransformer = new EventAccessTransformer();
    }

    @Override
    public int processClass(final ClassNode classNode, final Type classType) {
        if (ModLauncherFactory.hasPendingWrapperClass(classType.getClassName())) {
            ModLauncherFactory.processWrapperClass(classType.getClassName(), classNode);
            FabricatedForgeEventBus.LOGGER.debug(FabricatedForgeEventBus.EVENTBUS_MARKER, "Built transformed event wrapper class {}", classType.getClassName());
            return ClassWriter.COMPUTE_FRAMES;
        }
        final int evtXformFlags = eventTransformer.transform(classNode, classType).isPresent() ? ClassWriter.COMPUTE_FRAMES : 0x0;
        final int axXformFlags = accessTransformer.transform(classNode, classType) ? 0x100 : 0;
        return evtXformFlags | axXformFlags;
    }

    @Override
    public boolean handlesClass(final Type classType) {
        final String name = classType.getClassName();
        return !(name.startsWith("net.minecraft.") || name.indexOf('.') == -1);
    }

    @Override
    public boolean findASMEventDispatcher(final Type classType) {
        return ModLauncherFactory.hasPendingWrapperClass(classType.getClassName());
    }
}
