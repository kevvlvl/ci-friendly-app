package org.kevvlvl.cifriendly.app.calculator;

import org.kevvlvl.cifriendly.lib.calculator.ICalculator;
import org.kevvlvl.cifriendly.lib.calculator.SimpleCalculator;

import java.util.Random;

public class ApplicationMain {

    public static void main(String[] args) {

        Random rand = new Random();
        ICalculator calc = new SimpleCalculator(rand);

        int result = calc.add(10, 15);

        System.out.printf("\nThe result is %d", result);
    }
}
