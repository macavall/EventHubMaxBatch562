package com.function;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.*;

/**
 * Azure Functions with Event Hub trigger.
 */
public class EventHubTriggerJava1 {
    /**
     * This function will be invoked when an event is received from Event Hub.
     */
    @FunctionName("EventHubTriggerJava1")
    public void run(
        @EventHubTrigger(name = "message", eventHubName = "servicebusmaxbatchsize56eh1", connection = "servicebusmaxbatchsize56eh_RootManageSharedAccessKey_EVENTHUB", consumerGroup = "$Default", cardinality = Cardinality.MANY) List<String> message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Event Hub trigger function executed.");
        context.getLogger().info("Length:" + message.size());
        message.forEach(singleMessage -> context.getLogger().info(singleMessage));
    }
}
