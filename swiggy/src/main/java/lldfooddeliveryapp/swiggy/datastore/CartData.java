package lldfooddeliveryapp.swiggy.datastore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lldfooddeliveryapp.swiggy.exceptions.ExceptionType;
import lldfooddeliveryapp.swiggy.exceptions.FoodDeliveryException;
import lombok.Getter;
import lombok.NonNull;

@Component
@Getter
public class CartData {
	private Map<String, Map<String, List<String>>> userToRestaurantIdToListOfMenuItemIds = new HashMap<>();

	public List<String> getMenuItemIds(@NonNull final String userId, @NonNull final String restaurantId) {
		Map<String, List<String>> resturantsIdToMenuItems = userToRestaurantIdToListOfMenuItemIds.get(userId);
		if (!resturantsIdToMenuItems.containsKey(restaurantId)) {
			throw new FoodDeliveryException(ExceptionType.CART_IS_EMPTY, "cart is empty for this resturant");
		}
		return resturantsIdToMenuItems.get(restaurantId);
	}
	public Map<String, List<String>> getRestaurantIdToMenuItemIds(@NonNull final String userId) {
        return userToRestaurantIdToListOfMenuItemIds.containsKey(userId)?userToRestaurantIdToListOfMenuItemIds.get(userId):new HashMap<String, List<String>>();
    }
}
