package com.example.fyle.model;


import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name ="bank_branches")
public class BankAndBranches {
String ifsc;
long bankId;
String branch;
String address;
String city;
String district;
String state;
String bankName;
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public long getBankId() {
	return bankId;
}
public void setBankId(long bankId) {
	this.bankId = bankId;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
@Override
public String toString() {
	return "BankBranches [ifsc=" + ifsc + ", bankId=" + bankId + ", branch=" + branch + ", address=" + address
			+ ", city=" + city + ", district=" + district + ", state=" + state + ", bankName=" + bankName + "]";
}

}
