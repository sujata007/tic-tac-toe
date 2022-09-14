package lldfooddeliveryapp.swiggy.model;

import java.util.List;

import lldfooddeliveryapp.swiggy.enums.OrderStatus;
import lombok.Getter;
@Getter
public class Order {
	private String orderId;
	private String userId;
	private String resturantId;
	private List<MenuItem> menuItems;
	private OrderStatus orderStatus;
	Order(String orderId,String userId,String resturantId,List<MenuItem> menuItems){
		this.orderId = orderId;
		this.userId = userId;
		this.resturantId = resturantId;
		this.menuItems = menuItems;
	}
	public void makeOrderAsDelivered() {
		orderStatus = OrderStatus.DELIVERED;
	}
	public void makeOrderAsCancelled() {
		orderStatus = OrderStatus.CANCELLED;
	}
	public void makeOrderAsPlaced() {
		orderStatus = OrderStatus.PLACED;
	}
	public void makeOrderAsOutForDelivery() {
		orderStatus = OrderStatus.OUT_FOR_DELIVERY;
	}
	public void makeOrderAsPaymentPending() {
		orderStatus = OrderStatus.PAYMENT_PENDING;
	}
}
