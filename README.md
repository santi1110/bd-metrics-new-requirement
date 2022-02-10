### New Metric Requirement

Expected time required: 15 min

Your `OrderProcessor` class is running smoothly in production.  However, operations would like to keep track
of the time it takes to process orders.  They want to use this to set alarms for delayed times, identify busy
time periods, and get a baseline for how efficient the application is.

Your job is to implement that requirement by doing the following:

1. Update `OrderProcessor` and `MetricsPublisher` using the following information:
    1. Namespace: `EXAMPLE/ORDERS`
    2. Dimension: `ENVIRONMENT` with a value of `PRODUCTION`
    3. Metric Name: `ORDER_PROCESSING_TIMES`
    4. Metric Unit: `StandardUnit.Milliseconds`
    5. Metric Value: The time it takes to process an order
2. Identify where in the `processOrder` method to track the elapsed time.
3. Add code to track the elapsed time.
4. Use `MetricPublisher`'s `addMetric` method in the `processOrder` method to send the data to CloudWatch.

Note that, like the previous two activities, we've provided a separate `MetricsPublisher` class that integrates 
with CloudWatch, with the same two methods, `addMetric` and `buildMetricDataRequest`.  

HINTS:
* [I don't know how to measure the elapsed time in `processOrder`!](./hints/hint-01.md)
