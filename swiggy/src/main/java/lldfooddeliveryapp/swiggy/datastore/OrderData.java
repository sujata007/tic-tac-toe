package lldfooddeliveryapp.swiggy.datastore;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import lldfooddeliveryapp.swiggy.model.Order;
import lombok.Getter;

@Component
@Getter
public class OrderData {
	//Maps userIds to List of Order Ids
HashMap<String, List<String>> userIdToOrderIds = new HashMap<>();
//For Each Order id map the order
HashMap<String, Order> orderIdToOrder = new HashMap<>();
}
