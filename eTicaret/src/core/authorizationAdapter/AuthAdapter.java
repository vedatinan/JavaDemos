package core.authorizationAdapter;

import core.authorizationService.AuthService;
import googleAuthorization.GoogleAuth;

public class AuthAdapter implements AuthService{

	private GoogleAuth auth;

	@Override
	public void authSocialAccount(String email) {
		setAuth(new GoogleAuth());
		auth.SignUpGoogle(email);
		
		
	}

	public GoogleAuth getAuth() {
		return auth;
	}

	public void setAuth(GoogleAuth auth) {
		this.auth = auth;
	}

}
