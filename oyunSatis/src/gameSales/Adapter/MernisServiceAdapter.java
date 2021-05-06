package gameSales.Adapter;

import java.rmi.RemoteException;
import java.time.ZoneId;
import java.util.Date;

import gameSales.Abstract.IdentityValidationService;
import gameSales.Utils.Result.ErrorResult;
import gameSales.Utils.Result.Result;
import gameSales.Utils.Result.SuccessResult;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements IdentityValidationService{
	
	@Override
	public Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, int birthYear) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = true;
		
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(
					identityNumber,
					firstName.toUpperCase(),
					lastName.toUpperCase(), 
					birthYear
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(result) {
			return new SuccessResult();
		}else {
			return new ErrorResult(firstName.toUpperCase() + " " + lastName.toUpperCase() + " : Kimlik doğrulama başarısız.");
		}
			
	}
	
	/*
	 * For a `String` identityNumber
	 * */
	@Override
	public Result CheckIfRealPerson(String identityNumber, String firstName, String lastName, Date birthDate) {
		return this.CheckIfRealPerson(
				Long.parseLong(identityNumber), 
				firstName, 
				lastName, 
				birthDate
				);
	}	
	/*
	 * For a `Date` birthDate
	 * */
	@Override
	public Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, Date birthDate) {
		return this.CheckIfRealPerson(
				identityNumber, 
				firstName, 
				lastName, 
				birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()
				);
	}


}
