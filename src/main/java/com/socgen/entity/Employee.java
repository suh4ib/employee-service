package com.socgen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.socgen.rde.EmployeeDesignation;
import com.socgen.rde.EmployeeRole;
import com.socgen.rde.EmploymentType;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Enumerated(EnumType.STRING)
	private EmploymentType type;

	@Enumerated(EnumType.STRING)
	private EmployeeDesignation designation;

	@Enumerated(EnumType.STRING)
	private EmployeeRole role;

	@Column
	private Integer salary;

	@Column
	private Boolean isActive;

	// @Column
	// private LocalDate dateOfJoining;

	// @Column
	// private LocalDate dateOfLeaving;

	// @Column
	// private LocalDate dateOfBirth;

	@Column
	private String image;

	@Column
	private String gender;

	@Column
	private String phone;

	@Column
	private String address;

	@Column
	private String email;

	public String getEmployeeGender() {
		return gender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.gender = employeeGender;
	}

	public String getEmployeePhone() {
		return phone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.phone = employeePhone;
	}

	public String getEmployeeAddress() {
		return address;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.address = employeeAddress;
	}

	public String getEmployeeEmail() {
		return email;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.email = employeeEmail;
	}

	@ManyToOne(optional = false, targetEntity = Department.class)
	private Department department;

	public String getEmployeeImage() {
		return image;
	}

	public void setEmployeeImage(String employeeImage) {
		this.image = employeeImage;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getEmployeeId() {
		return id;
	}

	public EmployeeDesignation getEmployeeDesingation() {
		return designation;
	}

	public void setEmployeeDesingation(EmployeeDesignation employeeDesingation) {
		this.designation = employeeDesingation;
	}

	public EmployeeRole getEmployeeRole() {
		return role;
	}

	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.role = employeeRole;
	}

	public void setEmployeeId(Integer employeeId) {
		this.id = employeeId;
	}

	public String getEmployeeName() {
		return name;
	}

	public void setEmployeeName(String employeeName) {
		this.name = employeeName;
	}

	public EmploymentType getEmployeeType() {
		return type;
	}

	public void setEmployeeType(EmploymentType employeeType) {
		this.type = employeeType;
	}

	public Integer getEmployeeSalary() {
		return salary;
	}

	public void setEmployeeSalary(Integer employeeSalary) {
		this.salary = employeeSalary;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (type != null)
			builder.append("type=").append(type).append(", ");
		if (designation != null)
			builder.append("designation=").append(designation).append(", ");
		if (role != null)
			builder.append("role=").append(role).append(", ");
		if (salary != null)
			builder.append("salary=").append(salary).append(", ");
		if (isActive != null)
			builder.append("isActive=").append(isActive).append(", ");
		if (image != null)
			builder.append("image=").append(image).append(", ");
		if (gender != null)
			builder.append("gender=").append(gender).append(", ");
		if (phone != null)
			builder.append("phone=").append(phone).append(", ");
		if (address != null)
			builder.append("address=").append(address).append(", ");
		if (email != null)
			builder.append("email=").append(email).append(", ");
		if (department != null)
			builder.append("department=").append(department);
		builder.append("]");
		return builder.toString();
	}

	public Employee(String employeeName, EmploymentType employeeType, EmployeeDesignation employeeDesingation,
			EmployeeRole employeeRole, Integer employeeSalary, Boolean isActive, String employeeImage,
			String employeeGender, String employeePhone, String employeeAddress, String employeeEmail) {
		this.name = employeeName;
		this.type = employeeType;
		this.designation = employeeDesingation;
		this.role = employeeRole;
		this.salary = employeeSalary;
		this.isActive = isActive;
		this.image = employeeImage;
		this.gender = employeeGender;
		this.phone = employeePhone;
		this.address = employeeAddress;
		this.email = employeeEmail;
	}

}
