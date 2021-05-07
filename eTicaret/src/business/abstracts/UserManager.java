package business.abstracts;

import entities.concretes.UserInfo;

public interface UserManager extends UserService{
	public void RegisterUser(UserInfo user);
	public void LoginUser(String email,String password);
	public void SendConfirmEmail(String email);
	public void ConfirmAccount(UserInfo user);
}
