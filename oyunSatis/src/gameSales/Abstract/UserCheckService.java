package gameSales.Abstract;

import gameSales.Entity.User;
import gameSales.Utils.Result.Result;

public interface UserCheckService {
	public Result checkIsRealUser(User user);
}
