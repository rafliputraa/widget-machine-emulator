package com.plusle.labs.engine;

import com.plusle.labs.fuel.FuelType;

public class SteamEngineImpl implements Engine {

    private final int batchSize = 2;

    private boolean running;
    private int fuelLevel;
    private final FuelType fuelType;

    public SteamEngineImpl(FuelType fuelType) {
        if (!isFuelSupported(fuelType)) {
            throw new IllegalStateException("Fuel Type is not supported for Steam Engine.");
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
            throw new IllegalStateException("Not able to start the Steam Engine, because the Fuel couldn't be empty.");
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            running = false;
        } else {
            throw new IllegalStateException("Not able to stop the Steam Engine, because it's not started.");
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
        return fuelType.equals(FuelType.WOOD) || fuelType.equals(FuelType.COAL);
    }

    @Override
    public boolean isFuelEmpty() {
        return fuelLevel == 0;
    }
}
