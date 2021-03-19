package com.socgen.rde;

import java.util.ArrayList;
import java.util.List;

public enum ProofType {

	Aadhar, PAN;

	public static ProofType getProofType(String proofType) {
		for (ProofType entry : ProofType.values()) {
			if (entry.name().equalsIgnoreCase(proofType)) {
				return entry;
			}
		}
		return null;
	}

	public static List<String> getAllProofTypes() {
		List<String> list = new ArrayList<>(ProofType.values().length);
		for (ProofType entry : ProofType.values()) {
			list.add(entry.name());
		}
		return list;
	}

}
