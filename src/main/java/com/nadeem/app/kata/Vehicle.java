package com.nadeem.app.kata;

public abstract class Vehicle {
	private String name;
	private String id;
	private Size size;

	public Vehicle(String id, String name, Size size) {
		this.name = name;
		this.id = id;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Size getVehicleSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", id=" + id + ", Size=" + size + "]";
	}
	
}
