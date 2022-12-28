package com.plusle.labs.unit.machine;

import com.plusle.labs.engine.Engine;
import com.plusle.labs.engine.InternalCombustionEngineImpl;
import com.plusle.labs.engine.SteamEngineImpl;
import com.plusle.labs.fuel.FuelType;
import com.plusle.labs.machine.Widget;
import com.plusle.labs.machine.WidgetMachine;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WidgetMachineTest {

    Engine engine;
    Widget widget;

    @Test
    public void Should_ReturnValidCostValue_When_InternalCombustionEngineWithPetrol() {
        engine = new InternalCombustionEngineImpl(FuelType.PETROL);
        engine.fill(20);
        widget = new WidgetMachine(engine);
        double totalCost = widget.produceWidgets(56);
        assertThat(totalCost, equalTo(63.0));
    }

    @Test
    public void Should_ReturnValidCostValue_When_InternalCombustionEngineWithDiesel() {
        engine = new InternalCombustionEngineImpl(FuelType.DIESEL);
        engine.fill(30);
        widget = new WidgetMachine(engine);
        double totalCost = widget.produceWidgets(127);
        assertThat(totalCost, equalTo(192.0));
    }

    @Test
    public void Should_ReturnValidCostValue_When_SteamEngineWithWood() {
        engine = new SteamEngineImpl(FuelType.WOOD);
        engine.fill(55);
        widget = new WidgetMachine(engine);
        double totalCost = widget.produceWidgets(235);
        assertThat(totalCost, equalTo(513.3));
    }

    @Test
    public void Should_ReturnValidCostValue_When_SteamEngineWithCoal() {
        engine = new SteamEngineImpl(FuelType.COAL);
        engine.fill(99);
        widget = new WidgetMachine(engine);
        double totalCost = widget.produceWidgets(1529);
        assertThat(totalCost, equalTo(4322.25));
    }
}
