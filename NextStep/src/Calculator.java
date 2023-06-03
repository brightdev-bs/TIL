import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int splitAndGetSum(String s) {
        if(s == null || s.isBlank()) return 0;
        return getSum(toInts(splitString(s)));
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int num = n;
            if(num < 0) throw new RuntimeException();
            sum += num;
        }
        return sum;
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String values) {
        int parseInt = Integer.parseInt(values);
        if(parseInt < 0) {
            throw new RuntimeException();
        }
        return parseInt;
    }

    private String[] splitString(String s) {
        int sum;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);

        if(m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return s.split(",|:");
    }
}
