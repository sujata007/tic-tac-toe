package lldfooddeliveryapp.swiggy.commands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lldfooddeliveryapp.swiggy.datastore.OrderData;
import lldfooddeliveryapp.swiggy.enums.OrderCommandType;
import lldfooddeliveryapp.swiggy.enums.OrderStatus;
import lldfooddeliveryapp.swiggy.model.Order;

public class PlaceOrderCommandExecutor extends OrderCommandExecutor {
	private OrderData orderData;

    @Autowired
    public PlaceOrderCommandExecutor(OrderData orderData) {
        this.orderData = orderData;
    }
	@Override
	public boolean valid(Order order) {
		// TODO Auto-generated method stub
		if(!(order.getOrderStatus()==OrderStatus.PENDING)) {
			return false;
		}
		return true;
	}

	@Override
	public void executeCommand(Order order) {
		// TODO Auto-generated method stub
		orderData.getOrderIdToOrder().put(order.getOrderId(), order);
		List<String>listOfOrder = orderData.getUserIdToOrderIds().get(order.getUserId());
		listOfOrder.add(order.getOrderId());
		orderData.getUserIdToOrderIds().put(order.getUserId(), listOfOrder);
		order.makeOrderAsPaymentPending();

	}

	@Override
	public boolean isApplicable(OrderCommandType cartCommandType) {
		// TODO Auto-generated method stub
		return cartCommandType== OrderCommandType.PLACED;
	}

}
