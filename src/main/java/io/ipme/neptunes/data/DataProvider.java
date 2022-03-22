package io.ipme.neptunes.data;

import java.util.ArrayList;

import io.ipme.neptunes.Model.User;

public interface DataProvider {
	
	public ArrayList<User> getAll();
	
	public void add(User user);
}
