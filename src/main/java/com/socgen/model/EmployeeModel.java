package com.socgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socgen.entity.Department;

public class EmployeeModel {

	private Integer id;

	private String name;

	private String type;

	@JsonProperty("designation")
	private String designation;

	private String role;

	private Integer salary;

	private String image;

	private String gender;

	private String phone;

	private String address;

	private String email;

	private Department department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesingation() {
		return designation;
	}

	public void setDesingation(String desingation) {
		this.designation = desingation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeModel [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (type != null)
			builder.append("type=").append(type).append(", ");
		if (designation != null)
			builder.append("desingation=").append(designation).append(", ");
		if (role != null)
			builder.append("role=").append(role).append(", ");
		if (salary != null)
			builder.append("salary=").append(salary).append(", ");
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

}
