package business.abstracts;

import entities.concretes.UserInfo;

public interface UserService {
	public boolean nameControl(String firstName,String lastName);
	public boolean emailControl(String email);
	public boolean emailRegexControl(String email);
	public boolean passwordControl(String password);
	
	public UserInfo checkUser(String email,String password);
}
