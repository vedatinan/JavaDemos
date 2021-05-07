package eTicaret;

import business.concretes.LoginManager;
import core.authorizationAdapter.AuthAdapter;
import dataAccess.concretes.Database;
import entities.concretes.UserInfo;

public class Main {

	public static void main(String[] args) {
		UserInfo user1 = new UserInfo(1,"vedat", "inan", "vedatinan1996@gmail.com", "190519", false);
		LoginManager loginManager = new LoginManager(new Database());
		loginManager.RegisterUser(user1);
		loginManager.ConfirmAccount(user1);
		
		UserInfo user2 = new UserInfo(2,"engin", "demiroð", "engindemirliogullari@gmail.com", "190319", false);
		loginManager.RegisterUser(user2);
		
		UserInfo user3 = new UserInfo(3,"kemal","kýþlalýoðullarý","kislaliogullari_ogluu","190719", false);
		
		AuthAdapter auth = new AuthAdapter();
		auth.authSocialAccount(user3.getEmail());
		
		loginManager.LoginUser(user1.getEmail(), user1.getPassword());
		
		loginManager.LoginUser(user2.getEmail(), user2.getPassword());
	}

}
