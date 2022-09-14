package lldfooddeliveryapp.swiggy.service;

import java.util.List;

import lldfooddeliveryapp.swiggy.model.Restaurant;

public interface RestaurantService {

	void addRestaurant(Restaurant restaurant);

	List<Restaurant> getAllRestaurant();

	Restaurant getResturantById(String restaurantId);

	List<Restaurant> getResturantByName(String restaurantName);

	List<Restaurant> getResturantByCity(String cityName);
}
