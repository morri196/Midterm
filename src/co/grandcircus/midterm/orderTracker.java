package co.grandcircus.midterm;

import java.util.ArrayList;

public class orderTracker {
private ArrayList<Order> orderList = new ArrayList<Order>();

public orderTracker(ArrayList<Order> orderTracker) {
	super();
	this.orderList = orderTracker;
}

public ArrayList<Order> getOrderTracker() {
	return orderList;
}

public void setOrderTracker(ArrayList<Order> orderTracker) {
	this.orderList = orderTracker;
}

@Override
public String toString() {
	return "orderTracker [orderTracker=" + orderList + "]";
} 

 public void addOrder(Order order) {
	 orderList.add(order);
 }




}