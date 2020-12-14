package com.oos.booksrus;

public class Employee {
	private int employeeID;
	private String SSN;
	private String Name;
	private String address;
	private String phoneNumber;
	private String email;

	public Employee(int paramID, String paramSSN, String paramName,
			String paramAddress, String paramPhoneNumber, String paramEmail) {
		// Should system being creating employeeID on its own??
		employeeID = paramID;
		SSN = paramSSN;
		Name = paramName;
		address = paramAddress;
		phoneNumber = paramPhoneNumber;
		email = paramEmail;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}