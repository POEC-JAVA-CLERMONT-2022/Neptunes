/*
package io.ipme.neptunes.Service;

import java.util.ArrayList;

import io.ipme.neptunes.Data.UserDataProvider;
import io.ipme.neptunes.Data.InMemoryUserDataProvider;
import io.ipme.neptunes.Model.User;

public class UserService {
	private UserDataProvider dataProvider;
	
	public UserService() {
		dataProvider = new InMemoryUserDataProvider(); 
	}
	
	public ArrayList<User> getAll() {
		return dataProvider.getAll();
	}
	
	public void Add(User user) {
		if(user == null || user.getUserName() == null) {
			throw new IllegalArgumentException("User or user name is invalid"); 
		}
		dataProvider.add(user);
	}
}
*/
