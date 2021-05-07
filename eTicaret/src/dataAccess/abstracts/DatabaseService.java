package dataAccess.abstracts;

import entities.concretes.UserInfo;

public interface DatabaseService {
	public void add(UserInfo user);
	public void delete(UserInfo user);
}
