package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum EmploymentStatusType {

	Hired, Fired, Working, Resigned;

	public static EmploymentStatusType getEmployeeRole(String employmentStatusType) {
		for (EmploymentStatusType entry : EmploymentStatusType.values()) {
			if (entry.name().equalsIgnoreCase(employmentStatusType)) {
				return entry;
			}
		}
		return null;
	}

	public static List<String> getAllEmploymentStatusTypes() {
		List<String> list = new ArrayList<>(EmploymentStatusType.values().length);
		for (EmploymentStatusType entry : EmploymentStatusType.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
