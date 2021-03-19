package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum EmployeeDesignation {

	Officer, VicePresident, Director;

	public static EmployeeDesignation getEmployeeDesignation(String employeeRole) {
		for (EmployeeDesignation entry : EmployeeDesignation.values()) {
			if (entry.name().equalsIgnoreCase(employeeRole)) {
				return entry;
			}
		}
		return null;
	}
	
	public static List<String> getAllEmployeeRoles() {
		List<String> list = new ArrayList<>(EmployeeDesignation.values().length);
		for (EmployeeDesignation entry : EmployeeDesignation.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
