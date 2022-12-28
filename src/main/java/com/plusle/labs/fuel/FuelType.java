package com.plusle.labs.fuel;

public enum FuelType {
    PETROL(9.00),
    DIESEL(12.00),
    WOOD(4.35),
    COAL(5.65);

    private final double cost;

    FuelType(double cost) {
        this.cost = cost;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue() {
        return cost;
    }
}
