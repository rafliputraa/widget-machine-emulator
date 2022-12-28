package com.plusle.labs.unit.engine;

import com.plusle.labs.engine.Engine;
import com.plusle.labs.engine.InternalCombustionEngineImpl;
import com.plusle.labs.engine.SteamEngineImpl;
import com.plusle.labs.fuel.FuelType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SteamEngineImplTest {

    Engine engine;

    @Test
    public void Should_ReturnValidFuelType_When_FuelTypeWood() {
        engine = new SteamEngineImpl(FuelType.WOOD);
        assertThat(engine.getFuelType(), equalTo(FuelType.WOOD));
    }

    @Test
    public void Should_ReturnValidFuelType_When_FuelTypeCoal() {
        engine = new SteamEngineImpl(FuelType.COAL);
        assertThat(engine.getFuelType(), equalTo(FuelType.COAL));
    }

    @Test
    public void Should_NotAbleToCreateSteamEngine_When_FuelTypeDiesel() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new SteamEngineImpl(FuelType.DIESEL);
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Fuel Type is not supported for Steam Engine."));
    }

    @Test
    public void Should_NotAbleToCreateSteamEngine_When_FuelTypePetrol() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new SteamEngineImpl(FuelType.PETROL);
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Fuel Type is not supported for Steam Engine."));
    }

    @Test
    public void Should_StartSteamEngine_When_FuelTypeWood() {
        engine = new SteamEngineImpl(FuelType.WOOD);
        engine.fill(10);
        engine.start();
        assertThat(engine.isRunning(), equalTo(true));
    }

    @Test
    public void Should_StartSteamEngine_When_FuelTypeCoal() {
        engine = new SteamEngineImpl(FuelType.COAL);
        engine.fill(10);
        engine.start();
        assertThat(engine.isRunning(), equalTo(true));
    }

    @Test
    public void Should_StartSteamEngine_When_FuelLevelGreaterThanMax() {
        engine = new SteamEngineImpl(FuelType.WOOD);
        engine.fill(1000);
        engine.start();
        assertThat(engine.isRunning(), equalTo(true));
    }

    @Test
    public void Should_NotAbleToStartSteamEngine_When_FuelLevelIsEqualToZero() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new SteamEngineImpl(FuelType.WOOD);
            engine.start();
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Not able to start the Steam Engine, because the Fuel couldn't be empty."));
    }

    @Test
    public void Should_NotAbleToStartSteamEngine_When_FuelLevelIsLessThanZero() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new SteamEngineImpl(FuelType.WOOD);
            engine.fill(-10);
            engine.start();
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Not able to start the Steam Engine, because the Fuel couldn't be empty."));
    }

    @Test
    public void Should_StopSteamEngine_When_EngineSuccessfullyStarted() {
        engine = new SteamEngineImpl(FuelType.WOOD);
        engine.fill(10);
        engine.start();
        engine.stop();
        assertThat(engine.isRunning(), equalTo(false));
    }

    @Test
    public void Should_StopSteamEngine_When_EngineIsNotStarted() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new SteamEngineImpl(FuelType.WOOD);
            engine.stop();
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Not able to stop the Steam Engine, because it's not started."));
    }

    @Test
    public void Should_ReturnValidBatchSize_When_GetBatchSizeValueExecuted() {
        engine = new SteamEngineImpl(FuelType.WOOD);
        assertThat(engine.getBatchSize(), equalTo(2));
    }
}
