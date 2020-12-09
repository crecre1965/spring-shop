package fr.training.samples.spring.shop.exposition.order.rest;

import fr.training.samples.spring.shop.exposition.item.rest.ItemLightDto;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Validated
public class OrderLightDto implements Serializable {

	/**
	 * serialVersionUID of type long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * customerID of type String
	 */
	private String customerID;

	/**
	 * items of type Set of ItemDTO
	 */
	private List<String> items;

	/**
	 *
	 */
	public OrderLightDto() {
	}

	/**
	 * @return
	 */
	@NotNull
	public String getCustomerID() {
		return customerID;
	}
	@NotEmpty
	public List<String> getItems() {
		return items;
	}

	public void setItems(final List<String> items) {
		this.items = items;
	}

	public void setCustomerID(final String customerID) {
		this.customerID = customerID;
	}

}
