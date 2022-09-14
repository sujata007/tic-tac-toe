package lldfooddeliveryapp.swiggy.commands;

import lldfooddeliveryapp.swiggy.enums.CartCommandType;
import lldfooddeliveryapp.swiggy.exceptions.ExceptionType;
import lldfooddeliveryapp.swiggy.exceptions.FoodDeliveryException;
import lombok.NonNull;

public abstract class CartCommandExecutor {
	public void execute(@NonNull final String userId, @NonNull final String resturantID, @NonNull final String itemId) {
		if (!valid(userId, resturantID, itemId)) {
			throw new FoodDeliveryException(ExceptionType.MENU_ITEM_NOT_FOUNT, "menu item not found");
		}
	}

	public abstract boolean valid(String userId, String resturantID, String itemId);

	public abstract void executeCommand(String userId, String resturantID, String itemId);
	
	public abstract boolean isApplicable(CartCommandType cartCommandType);
}
