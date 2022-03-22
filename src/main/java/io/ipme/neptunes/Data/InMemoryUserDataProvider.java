package io.ipme.neptunes.Data;

import java.util.ArrayList;

import io.ipme.neptunes.Model.User;

public class InMemoryUserDataProvider implements UserDataProvider {
	
	private ArrayList<User> users = new ArrayList<User>();

	@Override
	public ArrayList<User> getAll() {
		return users;
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

}
