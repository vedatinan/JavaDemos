package gameSales.Concrete;

import gameSales.Abstract.BaseUserCheckManager;
import gameSales.Abstract.IdentityValidationService;
import gameSales.Entity.Player;
import gameSales.Entity.User;
import gameSales.Utils.Result.Result;

public class PlayerCheckManager extends BaseUserCheckManager {
	private IdentityValidationService identityValidationService;
	
	public PlayerCheckManager(IdentityValidationService identityValidationService){
		this.identityValidationService = identityValidationService;
	}
	
	@Override
	public Result checkIsRealUser(User user) {
		Player player = (Player)user;
		return this.identityValidationService.CheckIfRealPerson(
				player.getIdentityNumber(), 
				player.getFirstName(), 
				player.getLastName(), 
				player.getBirthDate()
				);
	}
}
