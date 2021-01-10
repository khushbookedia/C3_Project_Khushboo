//public class restaurantNotFoundException extends Throwable {
public class restaurantNotFoundException extends RuntimeException {
    public restaurantNotFoundException(String restaurantName) {
        super(restaurantName);
    }
}
