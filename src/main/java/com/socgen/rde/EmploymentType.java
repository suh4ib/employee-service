package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum EmploymentType {

	PartTime, FullTime, Internship;

	public static EmploymentType getEmploymentType(String employmentType) {
		for (EmploymentType entry : EmploymentType.values()) {
			if (entry.name().equalsIgnoreCase(employmentType)) {
				return entry;
			}
		}
		return null;
	}

	public static List<String> getAllEmploymentTypes() {
		List<String> list = new ArrayList<>(EmploymentType.values().length);
		for (EmploymentType entry : EmploymentType.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
