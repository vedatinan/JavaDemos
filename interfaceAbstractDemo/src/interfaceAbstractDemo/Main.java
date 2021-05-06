package interfaceAbstractDemo;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args)  {

	Customer customer = new Customer(1 , "Engin", "Demiroð", LocalDate.of(1985, 1, 6), "28861499108");
	
	
	BaseCustomerManager customermanager = new NeroCustomerManager(new MernisServiceAdapters());
	customermanager.save(customer);
	

}
}