package com.entity;

public class OrderDtls {

	private int id;
	private String orderId;
	private String userName;
	private String email;
	private String address;
	private String phoneNo;
	private String bookName;
	private String bookAuthor;
	private int price;
	private String paymentType;
	
	public OrderDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "OrderDtls [id=" + id + ", orderId=" + orderId + ", userName=" + userName + ", email=" + email
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", bookName=" + bookName + ", bookAuthor="
				+ bookAuthor + ", price=" + price + ", paymentType=" + paymentType + "]";
	}
	
	
	
	
}
