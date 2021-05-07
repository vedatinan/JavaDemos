package business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserManager;
import dataAccess.concretes.Database;
import entities.concretes.UserInfo;

public class LoginManager implements UserManager{
	
	List<UserInfo> users;
	String regex = "^(.+)@(.+)$";
	Pattern pattern = Pattern.compile(regex);
	
	public LoginManager(Database database) {
		this.users = database.getUsers();
	}

	@Override
	public boolean nameControl(String firstName, String lastName) {
		if(firstName.length() < 2 || lastName.length() < 2) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean emailControl(String email) {
		for(UserInfo user:users) {
			if(user.getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean emailRegexControl(String email) {
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches() == false) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean passwordControl(String password) {
		if(password.length() < 6) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public UserInfo checkUser(String email, String password) {
		for(UserInfo user : users) {
			if(email == user.getEmail()) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void RegisterUser(UserInfo user) {
		if(emailControl(user.getEmail()) == false) {
			System.out.println("Bu email daha önce kullanýldý");
		}else if(emailRegexControl(user.getEmail()) == false) {
			System.out.println("Email adresi kurallara uygun girilmedi");
		}else if(passwordControl(user.getPassword()) == false) {
			System.err.println("Þifre uzunluðu en az 6 karakter olmalý");
		}else if(nameControl(user.getFirstName(), user.getLastName()) == false) {
			System.err.println("Ad ve Soyad en az 2 karakter olmalý");
		}else {
			SendConfirmEmail(user.getEmail());
		}
		
	}

	@Override
	public void LoginUser(String email, String password) {
		UserInfo user = checkUser(email, password);
		if(user == null) {
			System.out.println("Kullanýcý bilgileri hatalý");
		}else if(password == user.getPassword()){
			System.out.println("Giriþ yapýldý");
		}else {
			System.out.println("Bilgilerinizi kontrol edin");
		}
	}

	@Override
	public void SendConfirmEmail(String email) {
		System.out.println(email + " : bu e-posta adresine doðrulama gönderildi.");
		
	}

	@Override
	public void ConfirmAccount(UserInfo user) {
		user.setConfirmed(true);
		users.add(user);
		System.out.println("Hesap doðrulandý , kayýt tamamlandý");
	}
	
}
