package calc;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String str) {
        String[] numbers = str.split(",|\n");
        if (str.isEmpty()) {
            return 0;
        }
        if (numbers.length == 1) {
            return stringToInt(str);
        } else {
            return getSumOfUnknownAmountOfNumbers(numbers);
        }
    }

    public int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    public int getSumOfUnknownAmountOfNumbers (String[] numbers) {
        checkNegativeNumbers(numbers);
        int sum = 0;
        for (String number : numbers) {
            sum += stringToInt(number);
        }
        return sum;
    }

    public void checkNegativeNumbers(String[] numbers) {
        List<String> negativeNumbers = new ArrayList<>();
        for (String number: numbers) {
            if (stringToInt(number) < 0) {
                negativeNumbers.add(number);
            } else if (!negativeNumbers.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
            }
        }
    }
}
