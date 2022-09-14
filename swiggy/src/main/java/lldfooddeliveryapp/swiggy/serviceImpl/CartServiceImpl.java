package lldfooddeliveryapp.swiggy.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lldfooddeliveryapp.swiggy.commands.CartCommandExecutor;
import lldfooddeliveryapp.swiggy.datastore.CartData;
import lldfooddeliveryapp.swiggy.enums.CartCommandType;
import lldfooddeliveryapp.swiggy.model.MenuItem;
import lldfooddeliveryapp.swiggy.service.CartService;
import lldfooddeliveryapp.swiggy.service.FoodMenuService;
@Service
public class CartServiceImpl implements CartService {
	private CartData cartData;
	private FoodMenuService foodMenuService;
	private List<CartCommandExecutor> cartCommandExecutorList;
	@Autowired
	CartServiceImpl(CartData cartData, FoodMenuService foodMenuService,List<CartCommandExecutor> cartCommandExecutorList){
		this.cartData = cartData;
		this.foodMenuService = foodMenuService;
		this.cartCommandExecutorList = cartCommandExecutorList;
		
	}

	@Override
	public void update(String userId, String resturantID, String itemId, CartCommandType cartCommandType) {
		// TODO Auto-generated method stub
		for(CartCommandExecutor cartCommandExecutor : cartCommandExecutorList) {
			if(cartCommandExecutor.isApplicable(cartCommandType)) {
				cartCommandExecutor.execute(userId, resturantID, itemId);
			}
		}

	}

	@Override
	public void clear(String userId, String restaurantId) {
		// TODO Auto-generated method stub
		Map<String, List<String>> restaurantToMenuItemsForAUser = cartData.getRestaurantIdToMenuItemIds(userId);
		if(!restaurantToMenuItemsForAUser.get(restaurantId).isEmpty()) {
			restaurantToMenuItemsForAUser.put(restaurantId, new ArrayList<String>());
		}

	}

	@Override
	public List<MenuItem> getAllItemsOfCart(String userId, String restaurantId) {
		// TODO Auto-generated method stub
		List<MenuItem> menuItems = new ArrayList<>();
        List<String> menuItemIds = cartData.getMenuItemIds(userId, restaurantId);
        menuItemIds.forEach(menuItem -> menuItems.add(foodMenuService.getMenuItemById(menuItem)));
        return menuItems;
	}

}
