package interfaceAbstractDemo;

public class NeroCustomerManager extends BaseCustomerManager {

	ICustomerCheckService customercheckservice;

	public NeroCustomerManager (ICustomerCheckService customercheckservice) {
		
		this.customercheckservice = customercheckservice;
	}

	@Override
	public void save(Customer customer) {

		if (customercheckservice.CheckIfRealPerson(customer)) {

			super.save(customer);
		} else {
			System.out.println("Not valid person");
		}

	}

}
