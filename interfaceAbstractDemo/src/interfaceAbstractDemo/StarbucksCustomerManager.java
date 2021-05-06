package interfaceAbstractDemo;

public class StarbucksCustomerManager extends BaseCustomerManager {
	
	
	ICustomerCheckService customercheckservice;
	
	
	public StarbucksCustomerManager(ICustomerCheckService customercheckservice) {
		
		this.customercheckservice = customercheckservice;
	}


	@Override
	public void save(Customer customer ) {
		
		if (customercheckservice.CheckIfRealPerson(customer)) {
			
			super.save(customer);
		}else {
			System.out.println("Not valid person");
		}
		
	}
	

}