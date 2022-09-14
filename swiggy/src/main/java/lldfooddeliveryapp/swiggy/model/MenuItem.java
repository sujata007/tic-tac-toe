package lldfooddeliveryapp.swiggy.model;

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
