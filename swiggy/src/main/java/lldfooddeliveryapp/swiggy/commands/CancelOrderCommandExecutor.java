package lldfooddeliveryapp.swiggy.commands;

import org.springframework.beans.factory.annotation.Autowired;

import lldfooddeliveryapp.swiggy.datastore.OrderData;
import lldfooddeliveryapp.swiggy.enums.OrderCommandType;
import lldfooddeliveryapp.swiggy.model.Order;

public class CancelOrderCommandExecutor extends OrderCommandExecutor {
	private OrderData orderData;

    @Autowired
    public CancelOrderCommandExecutor(OrderData orderData) {
        this.orderData = orderData;
    }
	@Override
	public boolean valid(Order order) {
		// TODO Auto-generated method stub
		if(!orderData.getOrderIdToOrder().containsKey(order.getOrderId())) {
			return false;
		}
		return true;
	}

	@Override
	public void executeCommand(Order order) {
		// TODO Auto-generated method stub
		order.makeOrderAsCancelled();

	}

	@Override
	public boolean isApplicable(OrderCommandType cartCommandType) {
		// TODO Auto-generated method stub
		return cartCommandType== OrderCommandType.CANCEl;
	}

}
