package com.nadeem.app.kata;

public class Slot {
	private String id;
	private Size size;
	private Vehicle vehicle;

	public Slot(final String id, final Size size) {
		this.id = id;
		this.size = size;
	}

	public void occupy(final Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle release() {
		Vehicle temp = this.vehicle;
		this.vehicle = null;
		return temp;
	}

	public Size getSize() {
		return size;
	}

	public String getId() {
		return id;
	}
}
