package com.amazon.ata.metrics.prework.newrequirement;

import com.amazon.ata.metrics.prework.newrequirement.resources.CreditProcessor;
import com.amazon.ata.metrics.prework.newrequirement.resources.CustomerManager;
import com.amazon.ata.metrics.prework.newrequirement.resources.InventoryManager;
import com.amazon.ata.metrics.prework.newrequirement.resources.Order;

/**
 * Class representing final state of the coding activity.
 */
public class OrderProcessor {

    private CustomerManager customerManager = new CustomerManager();
    private InventoryManager inventoryManager = new InventoryManager();
    private CreditProcessor creditProcessor = new CreditProcessor();
    private MetricsPublisher metricsPublisher;

    /**
     * Constructs a OrderProcessor object.
     *
     * @param metricsPublisher Used to publish metrics to CloudWatch.
     */
    public OrderProcessor(MetricsPublisher metricsPublisher) {
        this.metricsPublisher = metricsPublisher;
    }

    /**
     *  Processes orders by verifying the customer data, checking against the inventory, processing payment,
     *  and then allowing the order to be shipped.
     *
     * @param newOrder The order to be processed
     * @return True if the order was successfully processed, false otherwise.
     */
    public boolean processOrder(Order newOrder) {
        boolean success = false;

        try {
            customerManager.verifyCustomerInfo(newOrder);
            int pickListNumber = inventoryManager.createPickList(newOrder);
            creditProcessor.processPayment(newOrder);
            inventoryManager.processPickList(pickListNumber);
            success = true;
        } catch (Exception e) {
            System.out.println("Error processing order " + newOrder.getOrderNumber());
        }

        return success;
    }
}
