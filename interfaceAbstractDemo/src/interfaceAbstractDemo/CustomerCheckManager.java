package interfaceAbstractDemo;

public abstract class CustomerCheckManager implements ICustomerCheckService {

	
	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		return true;
	}

	


	
	
}