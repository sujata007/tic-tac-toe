package lldfooddeliveryapp.swiggy.commands;

import lldfooddeliveryapp.swiggy.enums.OrderCommandType;
import lldfooddeliveryapp.swiggy.exceptions.ExceptionType;
import lldfooddeliveryapp.swiggy.exceptions.FoodDeliveryException;
import lldfooddeliveryapp.swiggy.model.Order;
import lombok.NonNull;

public abstract class OrderCommandExecutor {
	public void execute(@NonNull final Order order) {
		if (!valid(order)) {
			throw new FoodDeliveryException(ExceptionType.ORDER_NOT_VALID, "Order is not valid");
		}
		executeCommand(order);
	}

	public abstract boolean valid(final Order order);

	public abstract void executeCommand(final Order order);
	
	public abstract boolean isApplicable(OrderCommandType cartCommandType);
}
