package lldfooddeliveryapp.swiggy.model;

import lldfooddeliveryapp.swiggy.enums.CuisineType;
import lldfooddeliveryapp.swiggy.enums.MealType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MenuItem {
	String id;
	String itemName;
	CuisineType cuisineType;
	MealType mealType;
}
