package org.portinglab.fabricatedeventbus;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

public interface EventBusEngineImpl {
    int processClass(ClassNode classNode, Type classType);

    boolean handlesClass(Type classType);

    boolean findASMEventDispatcher(Type classType);
}
