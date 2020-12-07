package fr.training.samples.spring.shop.exposition.order.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import fr.training.samples.spring.shop.exposition.customer.rest.CustomerDto;
import fr.training.samples.spring.shop.exposition.item.rest.ItemDto;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;
    private String orderID;
	private CustomerDto customer;
	private List<ItemDto> items;
	private int total;

	public OrderDto() {
	}


	public OrderDto(final String orderID, final CustomerDto customer) {
		this.orderID = orderID;
		this.customer = customer;
		items = new ArrayList<>();
	}

	/**
	 * /@param itemDTO
	 */
	public void addItem(final ItemDto itemDto) {
		items.add(itemDto);
	}

	/**
	 * @return
	 */
	public CustomerDto getCustomerID() {
		return customer;
	}

	/**
	 * @return
	 */
	public List<ItemDto> getItems() {
		return items;
	}

	/**
	 * @return
	 */
	public String getOrderID() {
		return orderID;
	}

	/**
	 *
	 */
	public void setCustomer(final CustomerDto customer) {

		this.customer = customer;
	}

	/**
	 * @param items
	 */
	public void setItems(final List<ItemDto> items) {
		this.items = items;
	}

	/**
	 * @param orderID
	 */
	public void setOrderID(final String orderID) {
		this.orderID = orderID;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("OrderDTO [orderID=");
		builder.append(orderID);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

}
