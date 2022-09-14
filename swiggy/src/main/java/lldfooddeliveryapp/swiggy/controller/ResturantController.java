package lldfooddeliveryapp.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lldfooddeliveryapp.swiggy.model.Restaurant;
import lldfooddeliveryapp.swiggy.service.RestaurantService;

@RestController
public class ResturantController {
	private RestaurantService restaurantService;
	
	@Autowired
	ResturantController(RestaurantService restaurantService){
		this.restaurantService = restaurantService;
	}
	@PostMapping(value = "/resturant")
	@ResponseStatus(HttpStatus.CREATED)
	public void addResturant(@RequestBody final Restaurant restaurant) {
		restaurantService.addRestaurant(restaurant);
	}

	@GetMapping(value = "/resturants")
	public List<Restaurant> getAllResturants() {
		return restaurantService.getAllRestaurant();

	}

	@GetMapping(value = "/resturants/{restaurantId}")
	public Restaurant getResturantById(final String restaurantId) {
		return restaurantService.getResturantById(restaurantId);
	}

	@GetMapping(value = "/resturants/name/{restaurantName}")
	public List<Restaurant> getResturantByName(final String restaurantName) {
		return restaurantService.getResturantByName(restaurantName);
	}

	@GetMapping(value = "/resturants/city/{cityName}")
	public List<Restaurant> getResturantByCity(final String cityName) {
		return restaurantService.getResturantByCity(cityName);
	}

}
