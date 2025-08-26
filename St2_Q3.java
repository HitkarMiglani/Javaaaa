

// Print k the Funny Numbers from a given start point

// Funny Numbers is a number whose sum of square of digits is 1.
// For example, 31 is a funny number because 9 + 1 = 10 -> 1 + 0 = 1

import java.util.*;

public class St2_Q3 {

    public static List<Integer> funny(int start, int n) {
        List<Integer> funnyNumbers = new ArrayList<>();
        int current = start;

        while (funnyNumbers.size() < n) {
            if (isFunny(current)) {
                funnyNumbers.add(current);
            }
            current++;
        }

        return funnyNumbers;
    }

    private static boolean isFunny(int num) {
        Set<Integer> seen = new HashSet<>();
        int current = num;

        while (current != 1 && !seen.contains(current)) {
            seen.add(current);
            current = getSum(current);
        }

        return current == 1;
    }

    private static int getSum(int i) {
        int sum = 0;
        int temp = i;
        while(temp > 0) {
            int digit = temp % 10;
            sum += digit * digit;
            temp /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        int start = 100;
        int n = 5;
        List<Integer> funnyNumbers = funny(start, n);
        System.out.println("The first " + n + " funny numbers starting from " + start + " are:");
        System.out.println(funnyNumbers);
    }
}
