package lldfooddeliveryapp.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lldfooddeliveryapp.swiggy.enums.CartCommandType;
import lldfooddeliveryapp.swiggy.model.MenuItem;
import lldfooddeliveryapp.swiggy.service.CartService;

@RestController
public class CartController {
	private CartService cartService;

	@Autowired
	CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping(value = "/users/{userId}/cart/update")
	public void updateCart(final String userId, final String cartId, final String itemId,
			final CartCommandType cartCommandType) {
		cartService.update(userId, cartId, itemId, cartCommandType);
	}

	@PutMapping(value = "/users/{userId}/cart/clear")
	public void updateCart(final String userId, final String restaurantId) {
		cartService.clear(userId, restaurantId);
	}
	@GetMapping(value = "/users/{userId}/cart")
	public List<MenuItem> getAllItemsOfCart(final String userId, final String restaurantId) {
		return cartService.getAllItemsOfCart(userId, restaurantId);
	}

}
