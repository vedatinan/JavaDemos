package kodlamaIo;

public class Main {

	public static void main(String[] args) {
		User vedat = new User();
		vedat.firstName = "Vedat";
		vedat.lastName = "İnan";
		vedat.email = "vedatinan1996@gmail.com";
		

		User engin = new User();
		engin.firstName = "Engin";
		engin.lastName = "Demiroğ";
		engin.email = "engindemirog@gmail.com";
	
		UserManager userManager = new UserManager();
		User[] users = { vedat, engin };

		userManager.addMultiple(users);

	}

}
