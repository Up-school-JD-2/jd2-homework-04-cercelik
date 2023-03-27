package UpSchoolHw.MusicStore;

public class UserManagement {

	private String userName;
	private String loginName;
	private String email;
	private String address;
	public  Basket basket;
	

	public UserManagement(String userName, String loginName, String email, String address) {
	
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.loginName = loginName;
		this.basket = new Basket(userName);

	}

	public String getUserName() {
		return userName;

	}
	
	public String getLoginName() {
		return loginName;

	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;

	}
	
	public Basket getBasket() {
		return basket;
	}

	public void UserInfo() {
		System.out.println(getLoginName());

	}



}
