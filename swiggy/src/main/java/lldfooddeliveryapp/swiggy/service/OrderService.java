package lldfooddeliveryapp.swiggy.service;

import java.util.List;

import lldfooddeliveryapp.swiggy.enums.OrderCommandType;
import lldfooddeliveryapp.swiggy.model.Order;

public interface OrderService {

	void updateOrder(Order order, OrderCommandType commandType);

	Order getOrderById(String orderId);

	List<Order> getAllOrderOfAUser(String userId);

	List<Order> getAllOrdersByRestaurant(String userId, String restaurantId);

}
