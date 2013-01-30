package registerOffice.businessObjects.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import registerOffice.businessObjects.persons.Customer;
@Entity
public class Processors extends Assortment{

	public Processors(String serialNumber, String model) {
		super(serialNumber, model);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getAssortmentDetails() {
		// TODO Auto-generated method stub
		return "This is a processor with s/n:" + getSerialNumber();
	}

	@Override
	public Assortment Clone() {
		// TODO Auto-generated method stub
		return null;
	}

}

