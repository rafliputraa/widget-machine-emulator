package com.plusle.labs.unit.fuel;

import com.plusle.labs.fuel.FuelType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FuelTypeTest {

    FuelType fuelType;

    @Test
    public void Should_ReturnValidValue_When_GetCostValueOfPetrol() {
        fuelType = FuelType.PETROL;
        assertThat(fuelType.getValue(), equalTo(9.00));
    }

    @Test
    public void Should_ReturnValidValue_When_GetCostValueOfDiesel() {
        fuelType = FuelType.DIESEL;
        assertThat(fuelType.getValue(), equalTo(12.00));
    }

    @Test
    public void Should_ReturnValidValue_When_GetCostValueOfWood() {
        fuelType = FuelType.WOOD;
        assertThat(fuelType.getValue(), equalTo(4.35));
    }

    @Test
    public void Should_ReturnValidValue_When_GetCostValueOfCoal() {
        fuelType = FuelType.COAL;
        assertThat(fuelType.getValue(), equalTo(5.65));
    }
}
