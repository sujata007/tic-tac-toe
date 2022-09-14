package lldfooddeliveryapp.swiggy.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class FoodMenu {
	private String id;
	private List<String> restaurantIds;
	private List<MenuItem> menuItemList;
}
