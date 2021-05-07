package dataAccess.concretes;

import java.util.ArrayList;

import java.util.List;

import dataAccess.abstracts.DatabaseService;
import entities.concretes.UserInfo;

public class Database implements DatabaseService{
	
	private List<UserInfo> users = new ArrayList<UserInfo>();

	@Override
	public void add(UserInfo user) {
		users.add(user);
		
	}

	@Override
	public void delete(UserInfo user) {
		users.remove(user);
		
	}
	public void getAllUsers() {
		for(UserInfo user:users) {
			System.out.println(user.getFirstName() + " " +  user.getLastName());
		}
	}

	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
}
