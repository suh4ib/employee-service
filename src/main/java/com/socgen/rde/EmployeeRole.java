package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum EmployeeRole {

	Lead, Developer, Operations, DevOps;

	public static EmployeeRole getEmployeeRole(String employeeDesignation) {
		for (EmployeeRole entry : EmployeeRole.values()) {
			if (entry.name().equalsIgnoreCase(employeeDesignation)) {
				return entry;
			}
		}
		return null;
	}

	public static List<String> getAllEmployeeDesignations() {
		List<String> list = new ArrayList<>(EmployeeRole.values().length);
		for (EmployeeRole entry : EmployeeRole.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
