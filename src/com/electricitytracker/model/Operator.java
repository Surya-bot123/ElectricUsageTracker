
package com.electricitytracker.model;

public class Operator extends User {

	public Operator() {
		super(1321, "Naveen	");
	}

	@Override
	public void showProfile() {
		System.out.println("Operator ID   : " + getId());
		System.out.println("Operator Name : " + getName());
	}
}
