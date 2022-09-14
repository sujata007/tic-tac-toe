package lldfooddeliveryapp.swiggy.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lldfooddeliveryapp.swiggy.commands.OrderCommandExecutor;
import lldfooddeliveryapp.swiggy.datastore.OrderData;
import lldfooddeliveryapp.swiggy.enums.OrderCommandType;
import lldfooddeliveryapp.swiggy.exceptions.ExceptionType;
import lldfooddeliveryapp.swiggy.exceptions.FoodDeliveryException;
import lldfooddeliveryapp.swiggy.model.Order;
import lldfooddeliveryapp.swiggy.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderData orderData;
	List<OrderCommandExecutor> orderCommandExecutor;

	OrderServiceImpl(OrderData orderData, List<OrderCommandExecutor> orderCommandExecutor) {
		this.orderData = orderData;
		this.orderCommandExecutor = orderCommandExecutor;
	}

	@Override
	public void updateOrder(Order order, OrderCommandType commandType) {
		// TODO Auto-generated method stub
		for(OrderCommandExecutor orderCommandExecutor :orderCommandExecutor) {
			if(orderCommandExecutor.isApplicable(commandType)) {
				orderCommandExecutor.execute(order);
			}
		}

	}

	@Override
	public Order getOrderById(String orderId) {
		// TODO Auto-generated method stub
		if (!orderData.getOrderIdToOrder().containsKey(orderId)) {
            throw new FoodDeliveryException(ExceptionType.ORDER_NOT_FOUND, "order not found");
        }
        return orderData.getOrderIdToOrder().get(orderId);
	}

	@Override
	public List<Order> getAllOrderOfAUser(String userId) {
		// TODO Auto-generated method stub
		 List<Order> orderList = new ArrayList<>();
		List<String> orderIds = orderData.getUserIdToOrderIds().get(userId);
		if(Optional.of(orderIds).isPresent()) {
			orderIds.forEach(orderId->orderList.add(getOrderById(orderId)));
		}
		return orderList;

	}

	@Override
	public List<Order> getAllOrdersByRestaurant(String userId, String restaurantId) {
		// TODO Auto-generated method stub
		 List<Order> orderIds = getAllOrderOfAUser(userId);
		 return orderIds.stream().filter(orderId -> orderId.getResturantId().equals(restaurantId)).collect(Collectors.toList());
	}

}
