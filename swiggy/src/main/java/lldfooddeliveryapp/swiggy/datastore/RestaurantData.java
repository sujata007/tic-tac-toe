package lldfooddeliveryapp.swiggy.datastore;



import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import lldfooddeliveryapp.swiggy.model.Restaurant;
import lombok.Getter;

@Component
@Getter
public class RestaurantData {
HashMap<String,Restaurant> restaurantById = new HashMap<>();
HashMap<String,List<String>> restaurantIdsByName = new HashMap<>();
HashMap<String,List<String>> restaurantIdsByCity = new HashMap<>();
}
