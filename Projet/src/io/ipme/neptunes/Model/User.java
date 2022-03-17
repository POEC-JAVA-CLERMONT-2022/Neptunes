package io.ipme.neptunes.Model;

public class User {
	/*
	 * 	Attributes
	 */
	private String userName;
	private String email;
	private String password;
	private String avatar;
	private Boolean isPremium;
	
	/*
	 * 	Constructors
	 */
	public User(String userName, String email, String password, String avatar, Boolean isPremium) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.isPremium = isPremium;
	}

	/*
	 * 	Getters
	 */
	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAvatar() {
		return avatar;
	}

	public Boolean getIsPremium() {
		return isPremium;
	}
	
	
	
}
