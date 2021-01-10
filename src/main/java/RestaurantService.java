import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{

        //The below code will search for the name of the restaurant and return true,
        // if it exists in the list of existing restaurants, else will throw a custom exception

            for (Restaurant restaurant : restaurants) {
                  if (restaurant.getName().equals(restaurantName))
                    return restaurant;
            }

            throw new restaurantNotFoundException("Error: Restaurant Not Found");

    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }


    //The below method will calculate the total price of the selected menu items, passed as a parameter to it.
    public int getTotalPrice(List<Item> selectedMenu) {
        int totalPrice = 0;

        for (Item item : selectedMenu) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }


}
