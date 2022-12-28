package com.plusle.labs.engine;

import com.plusle.labs.fuel.FuelType;

public interface Engine {

    void start();
    void stop();
    boolean isRunning();
    void fill(int fuelLevel);
    FuelType getFuelType();
    int getBatchSize();
    boolean isFuelSupported(FuelType fuelType);
    boolean isFuelEmpty();
    int minFuelLevel = 0;
    int maxFuelLevel = 100;
}
