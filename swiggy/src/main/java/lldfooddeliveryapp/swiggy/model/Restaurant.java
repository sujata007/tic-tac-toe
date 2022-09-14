package lldfooddeliveryapp.swiggy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Restaurant {
	private String id;
	private String name;
	private Address address;
}
