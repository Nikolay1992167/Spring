package by.it.academy.truck.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingExtensions implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        Logger logger = LogManager.getLogManager().getLogger(testInstance.getClass().toString());
        testInstance.getClass()
                .getMethod("setLogger", Logger.class)
                .invoke(testInstance, logger);
    }
}
