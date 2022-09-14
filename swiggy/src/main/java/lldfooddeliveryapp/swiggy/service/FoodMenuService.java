package lldfooddeliveryapp.swiggy.service;

import lldfooddeliveryapp.swiggy.model.FoodMenu;
import lldfooddeliveryapp.swiggy.model.MenuItem;

public interface FoodMenuService {

	MenuItem getMenuItemById(String menuItem);

	FoodMenu getMenuByRestaurantId(String resturantID);
	

}
