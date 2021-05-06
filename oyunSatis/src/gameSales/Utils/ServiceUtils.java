package gameSales.Utils;


import gameSales.Utils.Result.Result;
import gameSales.Utils.Result.SuccessResult;

public class ServiceUtils {
	public static Result runChecks(Result... results) {
		for (Result result : results) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();
	}

}
