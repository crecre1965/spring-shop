package fr.training.samples.spring.shop.exposition.order.rest;

import fr.training.samples.spring.shop.exposition.item.rest.ItemLightDto;

import java.io.Serializable;
import java.util.List;


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
	public String getCustomerID() {
		return customerID;
	}

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
