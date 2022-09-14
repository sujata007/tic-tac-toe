package lldfooddeliveryapp.swiggy.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import lldfooddeliveryapp.swiggy.datastore.CartData;
import lldfooddeliveryapp.swiggy.enums.CartCommandType;
import lldfooddeliveryapp.swiggy.model.FoodMenu;
import lldfooddeliveryapp.swiggy.service.FoodMenuService;

public class AddCartCommandExecutor extends CartCommandExecutor {
	private FoodMenuService foodMenuService;
    private CartData cartData;

    @Autowired
    public AddCartCommandExecutor(FoodMenuService foodMenuService, CartData cartData) {
        this.foodMenuService = foodMenuService;
        this.cartData = cartData;
    }
	@Override
	public boolean valid(String userId, String resturantID, String itemId) {
		// TODO Auto-generated method stub
		FoodMenu foodMenu = foodMenuService.getMenuByRestaurantId(resturantID);
		return foodMenu.getMenuItemList().stream()
                .filter(menuItem -> menuItem.getId().equals(itemId)).findAny().isPresent();
	}

	@Override
	public void executeCommand(String userId, String resturantID, String itemId) {
		// TODO Auto-generated method stub
		Map<String, List<String>> restaurantIdToMenuItemIds =
                cartData.getUserToRestaurantIdToListOfMenuItemIds().getOrDefault(userId, new HashMap<>());
        List<String> menuItemIds = restaurantIdToMenuItemIds.getOrDefault(resturantID, new ArrayList<>());
        menuItemIds.add(itemId);
        restaurantIdToMenuItemIds.put(resturantID, menuItemIds);
        cartData.getUserToRestaurantIdToListOfMenuItemIds().put(userId, restaurantIdToMenuItemIds);

	}

	@Override
	public boolean isApplicable(CartCommandType cartCommandType) {
		// TODO Auto-generated method stub
		return cartCommandType == CartCommandType.ADD_ITEM;
	}

}
