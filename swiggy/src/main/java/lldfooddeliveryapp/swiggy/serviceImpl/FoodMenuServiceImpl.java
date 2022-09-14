package lldfooddeliveryapp.swiggy.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lldfooddeliveryapp.swiggy.datastore.FoodMenuData;
import lldfooddeliveryapp.swiggy.exceptions.ExceptionType;
import lldfooddeliveryapp.swiggy.exceptions.FoodDeliveryException;
import lldfooddeliveryapp.swiggy.model.FoodMenu;
import lldfooddeliveryapp.swiggy.model.MenuItem;
import lldfooddeliveryapp.swiggy.service.FoodMenuService;
import lombok.NonNull;
@Service
public class FoodMenuServiceImpl implements FoodMenuService {
	private FoodMenuData foodMenuData;

	@Autowired
	FoodMenuServiceImpl(FoodMenuData foodMenuData) {
		this.foodMenuData = foodMenuData;
	}

	@Override
	public MenuItem getMenuItemById(@NonNull final String itemId) {
        if (!foodMenuData.getMenuItemById().containsKey(itemId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_ITEM_NOT_FOUND, "Menu Item not found");
        }
        return foodMenuData.getMenuItemById().get(itemId);
    }

	public FoodMenu getMenuByRestaurantId(@NonNull final String restaurantId) {
        if (!foodMenuData.getFoodMenuIdByRestaurantId().containsKey(restaurantId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_NOT_FOUND, "Food Menu not exists");
        }
        return getMenuById(foodMenuData.getFoodMenuIdByRestaurantId().get(restaurantId));
    }

	public FoodMenu getMenuById(String menuItemId) {
		// TODO Auto-generated method stub
		if(!foodMenuData.getFoodMenuById().containsKey(menuItemId)) {
			throw new FoodDeliveryException(ExceptionType.MENU_NOT_FOUND, "Food Menu not exists");
		}
		return foodMenuData.getFoodMenuById().get(menuItemId);
	}

}
