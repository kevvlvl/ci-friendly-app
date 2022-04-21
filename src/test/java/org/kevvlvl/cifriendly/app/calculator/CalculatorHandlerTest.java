package org.kevvlvl.cifriendly.app.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorHandlerTest {

    private CalculatorHandler handler;

    @BeforeEach
    void setup() {
        handler = new CalculatorHandler();
    }

    @Test
    void testAdditionOfTwoValidIntegers() {

        int num1 = 5;
        int num2 = 10;

        int result = handler.add(num1, num2);

        assertThat(result).isEqualTo(num1 + num2);
    }
}
