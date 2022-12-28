package com.plusle.labs.unit.engine;

import com.plusle.labs.engine.Engine;
import com.plusle.labs.engine.InternalCombustionEngineImpl;
import com.plusle.labs.fuel.FuelType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InternalCombustionEngineImplTest {

    Engine engine;

    @Test
    public void Should_ReturnValidFuelType_When_FuelTypePetrol() {
        engine = new InternalCombustionEngineImpl(FuelType.PETROL);
        assertThat(engine.getFuelType(), equalTo(FuelType.PETROL));
    }

    @Test
    public void Should_ReturnValidFuelType_When_FuelTypeDiesel() {
        engine = new InternalCombustionEngineImpl(FuelType.DIESEL);
        assertThat(engine.getFuelType(), equalTo(FuelType.DIESEL));
    }

    @Test
    public void Should_NotAbleToCreateInternalCombustionEngine_When_FuelTypeWood() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new InternalCombustionEngineImpl(FuelType.WOOD);
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Fuel Type is not supported for Internal Combustion Engine."));
    }

    @Test
    public void Should_NotAbleToCreateInternalCombustionEngine_When_FuelTypeCoal() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new InternalCombustionEngineImpl(FuelType.COAL);
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Fuel Type is not supported for Internal Combustion Engine."));
    }

    @Test
    public void Should_StartInternalCombustionEngine_When_FuelTypePetrol() {
        engine = new InternalCombustionEngineImpl(FuelType.PETROL);
        engine.fill(10);
        engine.start();
        assertThat(engine.isRunning(), equalTo(true));
    }

    @Test
    public void Should_StartInternalCombustionEngine_When_FuelTypeDiesel() {
        engine = new InternalCombustionEngineImpl(FuelType.DIESEL);
        engine.fill(10);
        engine.start();
        assertThat(engine.isRunning(), equalTo(true));
    }

    @Test
    public void Should_StartInternalCombustionEngine_When_FuelLevelGreaterThanMax() {
        engine = new InternalCombustionEngineImpl(FuelType.DIESEL);
        engine.fill(1000);
        engine.start();
        assertThat(engine.isRunning(), equalTo(true));
    }

    @Test
    public void Should_NotAbleToStartInternalCombustionEngine_When_FuelLevelIsEqualToZero() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new InternalCombustionEngineImpl(FuelType.PETROL);
            engine.start();
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Not able to start the Internal Combustion Engine, because the Fuel couldn't be empty."));
    }

    @Test
    public void Should_NotAbleToStartInternalCombustionEngine_When_FuelLevelIsLessThanZero() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new InternalCombustionEngineImpl(FuelType.PETROL);
            engine.fill(-10);
            engine.start();
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Not able to start the Internal Combustion Engine, because the Fuel couldn't be empty."));
    }

    @Test
    public void Should_StopInternalCombustionEngine_When_EngineSuccessfullyStarted() {
        engine = new InternalCombustionEngineImpl(FuelType.PETROL);
        engine.fill(10);
        engine.start();
        engine.stop();
        assertThat(engine.isRunning(), equalTo(false));
    }

    @Test
    public void Should_StopInternalCombustionEngine_When_EngineIsNotStarted() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            engine = new InternalCombustionEngineImpl(FuelType.PETROL);
            engine.stop();
        });
        assertThat(exception.getMessage(), equalToIgnoringCase("Not able to stop the Internal Combustion Engine, because it's not started."));
    }

    @Test
    public void Should_ReturnValidBatchSize_When_GetBatchSizeValueExecuted() {
        engine = new InternalCombustionEngineImpl(FuelType.PETROL);
        assertThat(engine.getBatchSize(), equalTo(8));
    }
}
