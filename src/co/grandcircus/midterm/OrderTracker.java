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

}