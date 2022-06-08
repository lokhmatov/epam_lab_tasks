package calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class StringCalculator {
    private static final Logger log = LogManager.getLogger(StringCalculator.class);
    private static final String DELIMETERS = "[,\\n]";
    public int add(String str) {
        String[] numbers = splitDelimeter(str);
        log.info("=================== START TEST ===================");
        log.info("String contains: " + "'" + str + "'");
        if (str.isEmpty()) {
            log.warn("String is empty!");
            return 0;
        }
        if (numbers.length == 1) {
            log.warn("String contains only one digit!");
            return stringToInt(str);
        } else {
            log.debug("Result: " + getSumOfUnknownAmountOfNumbers(numbers));
            return getSumOfUnknownAmountOfNumbers(numbers);
        }
    }

    public int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    public int getSumOfUnknownAmountOfNumbers(String[] numbers) {
        checkNegativeNumbers(numbers);
        int sum = 0;
        for (String number : numbers) {
            sum += stringToInt(number);
        }
        return sum;
    }

    public void checkNegativeNumbers(String[] numbers) {
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            if (stringToInt(number) < 0) {
                negativeNumbers.add(number);
            } else if (!negativeNumbers.isEmpty()) {
                log.error("Negatives not allowed: " + negativeNumbers);
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
            }
        }
    }

    public String[] splitDelimeter(String str) {
        if (hasCustomDelimiter(str)) {
            return str.substring(str.indexOf("\n") + 1)
                    .split(extractDelimeter(str));
        }
        return str.split(DELIMETERS);
    }

    public String extractDelimeter(String str) {
        String escapedNumber;
        int startOfSubstring = str.indexOf("\n");
        escapedNumber = str.substring(0, startOfSubstring)
                .replace("//", "")
                .replace("[", "")
                .replace("]", "");
        return escapedNumber;
    }

    public boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("/");
    }
}
