import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivide {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator:   ");
            int a = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int b = scanner.nextInt();

            int result = a / b;
            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input: please enter whole numbers only");
        } catch (ArithmeticException e) {
            System.out.println("Math error: cannot divide by zero");
        } finally {
            scanner.close(); // always release the scanner
            System.out.println("Done");
        }
    }
}