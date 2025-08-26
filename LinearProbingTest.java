import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LinearProbingTest {

    // Runs the Linear_Probing main with given input, captures and returns output
    private static String runWithInput(String input) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setIn(inStream);
        System.setOut(new PrintStream(outStream));

        try {
            Linear_Probing.main(new String[0]);
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        } finally {
            System.setIn(System.in);
            System.setOut(originalOut);
        }

        return outStream.toString().trim();
    }

    // Test 1: Basic insertion without collisions
    public static void testBasicInsertion() {
        String input = "3\n1\n2\n3";
        String output = runWithInput(input);
        String expected = "-1 1 2 3 -1 -1 -1 -1 -1 -1 -1";

        printResult("Test Case 1: Basic insertion without collisions", input, expected, output);
    }

    // Test 2: Handling single collision
    public static void testSingleCollision() {
        String input = "3\n1\n12\n23";
        String output = runWithInput(input);
        String expected = "-1 1 12 23 -1 -1 -1 -1 -1 -1 -1";

        printResult("Test Case 2: Handling collisions with linear probing", input, expected, output);
    }

    // Test 3: Multiple collisions with wrap-around
    public static void testMultipleCollisions() {
        String input = "6\n0\n11\n22\n33\n44\n55";
        String output = runWithInput(input);
        String expected = "0 11 22 33 44 55 -1 -1 -1 -1 -1";

        printResult("Test Case 3: Multiple collisions requiring wrap-around", input, expected, output);
    }

    // Test 4: Fill entire hash table
    public static void testFullTable() {
        String input = "11\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11";
        String output = runWithInput(input);
        String expected = "11 1 2 3 4 5 6 7 8 9 10";

        printResult("Test Case 4: Fill the entire hash table", input, expected, output);
    }

    // Test 5: Overflow condition
    public static void testOverflow() {
        String input = "12\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12";
        String output = runWithInput(input);

        boolean hasErrorMessage = output.contains("full") || output.contains("Hash table is full");
        System.out.println("Test Case 5: Overflow condition");
        System.out.println("Input: " + input.replace("\n", " "));
        System.out.println("Expected: Some form of 'Hash table is full!' message");
        System.out.println("Actual: " + output);
        System.out.println("Result: " + (hasErrorMessage ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Utility method to print formatted test results
    private static void printResult(String testCase, String input, String expected, String output) {
        System.out.println(testCase);
        System.out.println("Input: " + input.replace("\n", " "));
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + output);
        System.out.println("Result: " + (expected.equals(output) ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Main entry point
    public static void main(String[] args) {
        System.out.println("Running tests for Linear_Probing class...\n");

        testBasicInsertion();
        testSingleCollision();
        testMultipleCollisions();
        testFullTable();
        testOverflow();

        System.out.println("All tests completed.");
    }
}
