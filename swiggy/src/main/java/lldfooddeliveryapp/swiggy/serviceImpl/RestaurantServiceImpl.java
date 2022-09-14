package lldfooddeliveryapp.swiggy.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lldfooddeliveryapp.swiggy.datastore.RestaurantData;
import lldfooddeliveryapp.swiggy.exceptions.ExceptionType;
import lldfooddeliveryapp.swiggy.exceptions.FoodDeliveryException;
import lldfooddeliveryapp.swiggy.model.Restaurant;
import lldfooddeliveryapp.swiggy.service.RestaurantService;
@Service
public class RestaurantServiceImpl implements RestaurantService {
	private RestaurantData restaurantData;

	@Autowired
	RestaurantServiceImpl(RestaurantData restaurantData) {
		this.restaurantData = restaurantData;
	}

	public void addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		if (restaurantData.getRestaurantById().containsKey(restaurant.getId())) {
			throw new FoodDeliveryException(ExceptionType.RESTAURANT_ALREADY_EXISTS, "Duplicate Restaurant");
		}
		restaurantData.getRestaurantById().put(restaurant.getId(), restaurant);
		List<String> resturantsByName = restaurantData.getRestaurantIdsByName().get(restaurant.getName());
		if (resturantsByName == null) {
			resturantsByName = new ArrayList<>();
		}
		resturantsByName.add(restaurant.getId());
		restaurantData.getRestaurantIdsByName().put(restaurant.getName(), resturantsByName);
		List<String> resturantsByCity = restaurantData.getRestaurantIdsByCity().get(restaurant.getAddress().getCity());
		if (resturantsByCity == null) {
			resturantsByCity = new ArrayList<>();
		}
		resturantsByCity.add(restaurant.getId());
		restaurantData.getRestaurantIdsByCity().put(restaurant.getAddress().getCity(), resturantsByCity);
	}

	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return new ArrayList<>(restaurantData.getRestaurantById().values());
	}

	public Restaurant getResturantById(String restaurantId) {
		// TODO Auto-generated method stub
		if (restaurantData.getRestaurantById().containsKey(restaurantId)) {
			new FoodDeliveryException(ExceptionType.RESTAURANT_NOT_FOUND, "Resturant Doesn't exists");
		}
		return restaurantData.getRestaurantById().get(restaurantId);
	}

	public List<Restaurant> getResturantByName(String restaurantName) {
		// TODO Auto-generated method stub
		List<Restaurant> result = new ArrayList<>();
		for (String restaurantId : restaurantData.getRestaurantIdsByName().get(restaurantName)) {
			result.add(getResturantById(restaurantId));
		}
		return result;
	}

	public List<Restaurant> getResturantByCity(String cityName) {
		// TODO Auto-generated method stub
		List<Restaurant> result = new ArrayList<>();
		for (String restaurantId : restaurantData.getRestaurantIdsByCity().get(cityName)) {
			result.add(getResturantById(restaurantId));
		}
		return result;
	}

}
