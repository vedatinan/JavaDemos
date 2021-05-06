package interfaceAbstractDemo;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapters  implements ICustomerCheckService{
	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		KPSPublicSoapProxy kpsPublic =new KPSPublicSoapProxy();
		
		boolean result=false;
		
		
		try {	
			
			result=kpsPublic.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),
					customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), 
					Integer.parseInt(customer.getDateOfBirth()));
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean CheckIfRealCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
