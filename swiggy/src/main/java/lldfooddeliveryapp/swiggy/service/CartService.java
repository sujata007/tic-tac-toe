package lldfooddeliveryapp.swiggy.service;

import java.util.List;

import lldfooddeliveryapp.swiggy.enums.CartCommandType;
import lldfooddeliveryapp.swiggy.model.MenuItem;

public interface CartService {

	void update(String userId, String cartId, String itemId, CartCommandType cartCommandType);

	void clear(String userId, String restaurantId);

	List<MenuItem> getAllItemsOfCart(String userId, String restaurantId);

}
