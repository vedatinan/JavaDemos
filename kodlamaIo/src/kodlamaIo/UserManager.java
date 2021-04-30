package kodlamaIo;

public class UserManager {
	public void add(User user) {
		String mesaj = user.firstName + " " + user.lastName + " " + user.email + " Kaydedildi.";
		System.out.println(mesaj);
	}

	public void addMultiple(User[] users) {
		for (User user : users) {
			add(user);
		}
	}

}
