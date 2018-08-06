package co.grandcircus.midterm;

import java.util.ArrayList;

public class OrderTracker {
	private ArrayList<Order> orderList = new ArrayList<Order>();

	public OrderTracker(ArrayList<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	public OrderTracker() {

	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "OrderTracker [orderList=" + orderList + "]";
	}

	public void addOrder(Order order) {
		orderList.add(order);
	}
	
	// TODO: Write a method that loops through every order and prints its grand total
	// e.g. "Order 1 - $2.75
	// e.g. "Order 2 - $800.45
	// TODO: get fancy and make it print a sum of all the grand totals.

}