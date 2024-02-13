public class ArrayFullException extends Exception {
    public ArrayFullException(Object value) {
        super("The array is full and " + value + " cannot be inserted.");
    }
}