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

	public void orderSummary() {
		System.out.print("=============================================\n");
		double allOrdersTotal = 0;
		
		for (int i = 1; i <= orderList.size(); i++) {
			double orderTotal = orderList.get(i - 1).getGrandTotal();
			allOrdersTotal += orderTotal;
			String orderTotalString = String.format("$%.2f", orderTotal);
			System.out.printf("%-25s%20s%n", ("Order " + i + ": "), orderTotalString);
		}
		
		System.out.print("=============================================\n");
		String allOrdersTotalString = String.format("$%.2f", allOrdersTotal);
		System.out.printf("%-25s%20s%n%n", "Today's Taco Haul:", allOrdersTotalString);
		
	}

}