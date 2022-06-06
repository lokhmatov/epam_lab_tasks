package calc;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String DELIMETERS = "[,\\n]";

    public int add(String str) {
        String[] numbers = splitDelimeter(str);
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

    private String[] splitDelimeter (String str) {
        if (hasCustomDelimiter(str)) {
            return str.substring(str.indexOf("\n") + 1)
                      .split(extractDelimeter(str));
        }
        return str.split(DELIMETERS);
    }

    private String extractDelimeter(String str) {
        String escapedNumber;
        int startOfSubstring = str.indexOf("\n");
        escapedNumber = str.substring(0, startOfSubstring)
                .replace("//", "")
                .replace("[", "")
                .replace("]", "");
        return escapedNumber;
    }

    private boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("/");
    }
}
