package org.portinglab.fabricatedeventbus;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.MarkerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class FabricatedForgeEventBus implements ModInitializer {
    public static final String MODID = "fabricated-eventbus";
    public static final String MODNAME = "FabricatedForgeEventBus";
    public static final String MARKER = "EVENTBUS";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODNAME);
    static final org.apache.logging.log4j.Marker EVENTBUS = MarkerManager.getMarker(MARKER);
    public static final Marker EVENTBUS_MARKER = MarkerFactory.getMarker(MARKER);

    @Override
    public void onInitialize() {

    }
}
