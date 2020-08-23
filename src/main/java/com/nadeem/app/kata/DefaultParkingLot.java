package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultParkingLot implements ParkingLot {

	private final List<Slot> smallSlots;
	private final List<Slot> mediumSlots;
	private final List<Slot> largeSlots;

	private Map<String, Slot> occupiedSlots = new HashMap<String, Slot>();

	public DefaultParkingLot(int smallSlotsCount, int mediumSlotCount, int largeSlotCount) {
		this.smallSlots = createList(smallSlotsCount, Size.SMALL);
		this.mediumSlots = createList(mediumSlotCount, Size.MEDIUM);
		this.largeSlots = createList(largeSlotCount, Size.LARGE);
	}

	private List<Slot> createList(int count, final Size size) {
		List<Slot> result = new ArrayList<Slot>(count);
		for (int i = 0; i < count; i++) {
			result.add(new Slot(size.name() + i, size));
		}		
		return result;		
	}

	public String park(final Vehicle vehicle) {
		Slot newSlot;
		try {
			newSlot = findSlot(vehicle.getVehicleSize());
		} catch (Exception e) {
			throw new IllegalStateException("Parking full");
		}
		newSlot.occupy(vehicle);
		occupiedSlots.put(vehicle.getId(), newSlot);
		return newSlot.getId();
	}

	private Slot findSlot(final Size vehicleSize) {
		if (Size.SMALL.equals(vehicleSize)) {
			return this.smallSlots.remove(0);
		} else if (Size.MEDIUM.equals(vehicleSize)) {
			return this.mediumSlots.remove(0);
		} else {
			return this.largeSlots.remove(0);
		}
	}

	public Vehicle leave(final String id) {
		Slot slot = this.occupiedSlots.get(id);
		if (slot == null) {
			throw new IllegalArgumentException("Vehicle not parked");
		}
		Vehicle vehicle = slot.release();
		addBack(slot);
		return vehicle;
	}

	private void addBack(final Slot slot) {	
		if (Size.SMALL.equals(slot.getSize())) {
			this.smallSlots.add(slot);
		} else if (Size.MEDIUM.equals(slot.getSize())) {
			this.mediumSlots.add(slot);
		} else {
			this.largeSlots.add(slot);
		}		
	}
}
