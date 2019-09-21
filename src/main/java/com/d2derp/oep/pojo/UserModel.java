package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.UserType;

@Component
public class UserModel {
	
	private int id;
	private int sno;
	private String firstName;
	private String lastName;
	private String email;
	private int mobileNumber;
	private String pass;
	private String cpass;
	private String status;
	private int createdDate;
	private int lastModifiedDate;
	private int ipAddress;
	private UserType userType;
	private Client client;
	private int cId;
	private int userTypeId;
	
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(int createdDate) {
		this.createdDate = createdDate;
	}
	public int getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(int lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public int getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(int ipAddress) {
		this.ipAddress = ipAddress;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
