package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum AddressType {

	Permanent, Residential, Business;

	public static AddressType getAddressType(String addressType) {
		for (AddressType entry : AddressType.values()) {
			if (entry.name().equalsIgnoreCase(addressType)) {
				return entry;
			}
		}
		return null;
	}

	public static List<String> getAllAddressTypes() {
		List<String> list = new ArrayList<>(AddressType.values().length);
		for (AddressType entry : AddressType.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
