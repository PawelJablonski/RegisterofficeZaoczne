package registerOffice.management;

import java.util.ArrayList;
import java.util.List;

import registerOffice.businessObjects.orders.Assortment;
import registerOffice.businessObjects.persons.Customer;

public class DatabaseContext {

	private static List<Customer> persons=new ArrayList<Customer>();
	private static List<Assortment> cars=new ArrayList<Assortment>();
	
	public static List<Customer> getPersons() {
		return persons;
	}
	public static List<Assortment> getCars() {
		return cars;
	}
	
	
}
