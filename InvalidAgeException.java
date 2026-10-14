public class InvalidAgeException extends Exception {
    private final int invalidAge;

    public InvalidAgeException(String message, int invalidAge) {
        super(message);
        this.invalidAge = invalidAge;
    }

    public int getInvalidAge() { return invalidAge; }
}