package com.plusle.labs.machine;

import com.plusle.labs.engine.Engine;

public class WidgetMachine implements Widget{

    private final Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0.0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        final int batchSize = engine.getBatchSize();
        final double costEachBatch = engine.getFuelType().getValue();

        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costEachBatch;
    }


}
