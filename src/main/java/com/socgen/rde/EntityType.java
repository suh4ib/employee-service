package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum EntityType {

	Employee, Department;

	public static EntityType getEntityType(String entityType) {
		for (EntityType entry : EntityType.values()) {
			if (entry.name().equalsIgnoreCase(entityType)) {
				return entry;
			}
		}
		return null;
	}

	public static List<String> getAllEntityTypes() {
		List<String> list = new ArrayList<>(EntityType.values().length);
		for (EntityType entry : EntityType.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
