package com.company;

public class UserVO {
	private Address address;
	private String postCode;

	UserVO(Address address, String postCode) {
		this.address = address;
		this.postCode = postCode;
	}
	public Address getAddress() {
		return address;
	}

	public String getPostCode() {
		return postCode;
	}
}
