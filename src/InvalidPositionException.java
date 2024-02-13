public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(int upper) {
        super("Position must be between 1 and " + upper);
    }
}