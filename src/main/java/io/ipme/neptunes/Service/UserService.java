package io.ipme.neptunes.Service;

import java.util.ArrayList;

import io.ipme.neptunes.Data.DataProvider;
import io.ipme.neptunes.Data.InMemoryDataProvider;
import io.ipme.neptunes.Model.User;

public class UserService {
	private DataProvider dataProvider;
	
	public UserService() {
		dataProvider = new InMemoryDataProvider(); 
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
