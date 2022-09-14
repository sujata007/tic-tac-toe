package lldfooddeliveryapp.swiggy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Address {
	private String id;
	private String streetAddress;
	private String city;
	private String zipcode;
}
