
import calc.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void returnZeroWhenStringIsEmpty() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void returnNumberForOneNumber() {
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void returnSumOfTwoComaDelimitedNumbers (){
        assertEquals(1, stringCalculator.add("1,0"));
    }

    @Test
    public void returnSumOfUnknownAmountOfNumbers() {
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }

    @Test
    public void returnSumNewLineDelimitedNumbers() {
        assertEquals(3, stringCalculator.add("1\n2"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkAndReturnNegativeNumbers() {
        stringCalculator.add("1,-2,4");
    }

    @Test
    public void returnSumWithDifferentDelimiters() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
}
