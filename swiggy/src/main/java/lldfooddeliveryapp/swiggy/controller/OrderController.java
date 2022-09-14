package lldfooddeliveryapp.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lldfooddeliveryapp.swiggy.enums.OrderCommandType;
import lldfooddeliveryapp.swiggy.model.Order;
import lldfooddeliveryapp.swiggy.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping(value = "/user/{userId}/order/update")
	public void updateOrder(final Order order, final OrderCommandType commandType) {
		orderService.updateOrder(order,commandType);
	}
	@GetMapping(value = "/user/{orderId}/")
	public Order getOrderById(final String orderId) {
		return orderService.getOrderById(orderId);
		
	}
	@GetMapping(value = "/user/{userId}/order")
	public List<Order> getAllOrderOfAUser(final String userId) {
		return orderService.getAllOrderOfAUser(userId);
		
	}
	@GetMapping(value = "/user/{userId}/order/{restaurantId}")
	public List<Order> getAllOrdersByRestaurant(final String userId,final String restaurantId) {
		return orderService.getAllOrdersByRestaurant(userId,restaurantId);
		
	}
	
}
