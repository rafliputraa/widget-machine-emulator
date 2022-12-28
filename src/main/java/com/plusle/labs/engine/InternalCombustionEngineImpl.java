package com.plusle.labs.engine;

import com.plusle.labs.fuel.FuelType;

public class InternalCombustionEngineImpl implements Engine {

    private final int batchSize = 8;

    private boolean running;
    private int fuelLevel;
    private final FuelType fuelType;

    public InternalCombustionEngineImpl(FuelType fuelType) {
        if (!isFuelSupported(fuelType)) {
            throw new IllegalStateException("Fuel Type is not supported for Internal Combustion Engine.");
        } else {
            this.fuelType = fuelType;
        }
        running = false;
        fuelLevel = 0;
    }

    @Override
    public void start() {
        if (!isFuelEmpty()) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start the Internal Combustion Engine, because the Fuel couldn't be empty.");
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            running = false;
        } else {
            throw new IllegalStateException("Not able to stop the Internal Combustion Engine, because it's not started.");
        }
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(int fuelLevel) {
        if (fuelLevel >= minFuelLevel && fuelLevel <= maxFuelLevel) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > maxFuelLevel) {
            this.fuelLevel = maxFuelLevel;
        } else {
            this.fuelLevel = minFuelLevel;
        }
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public int getBatchSize() {
        return batchSize;
    }

    @Override
    public boolean isFuelSupported(FuelType fuelType) {
        return fuelType.equals(FuelType.PETROL) || fuelType.equals(FuelType.DIESEL);
    }

    @Override
    public boolean isFuelEmpty() {
        return fuelLevel == 0;
    }
}
