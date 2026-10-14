public class AgeValidator {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException(
                "Age " + age + " is outside the valid range 0..120",
                age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] testAges = {25, -5, 130, 0, 120, 121};

        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage()
                    + " (invalid value: " + e.getInvalidAge() + ")");
            }
        }
    }
}