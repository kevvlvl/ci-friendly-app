package org.kevvlvl.cifriendly.app.calculator;

import org.kevvlvl.cifriendly.lib.calculator.ICalculator;
import org.kevvlvl.cifriendly.lib.calculator.SimpleCalculator;

import java.util.Random;

public class CalculatorHandler {

    private final ICalculator calc;

    public CalculatorHandler() {

        calc = new SimpleCalculator(new Random());
    }

    public int add(int num1, int num2) {

        int result = calc.add(num1, num2);
        System.out.printf("\nThe result is %d", result);

        return result;
    }
}
