package com.socgen.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Integer id;

	@Column
	@JsonProperty("name")
	private String name;

	@Column
	@JsonProperty("code")
	private String code;

	@Column
	private Boolean isActive;

	@OneToMany(targetEntity = Employee.class, mappedBy = "id")
	private List<Employee> employeeList;

	public Integer getDepartmentId() {
		return id;
	}

	public void setDepartmentId(Integer departmentId) {
		this.id = departmentId;
	}

	public String getDepartmentName() {
		return name;
	}

	public void setDepartmentName(String departmentName) {
		this.name = departmentName;
	}

	public String getDepartmentCode() {
		return code;
	}

	public void setDepartmentCode(String departmentCode) {
		this.code = departmentCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Department() {
	}

	public Department(String departmentName, String departmentCode, Boolean isActive) {
		this.name = departmentName;
		this.code = departmentCode;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (code != null)
			builder.append("code=").append(code).append(", ");
		if (isActive != null)
			builder.append("isActive=").append(isActive);
		builder.append("]");
		return builder.toString();
	}

}
