package registerOffice.businessObjects.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import registerOffice.businessObjects.persons.Customer;
@Entity
public class Memory extends Assortment{

	public Memory(String serialNumber, String model) {
		super(serialNumber, model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAssortmentDetails() {
		// TODO Auto-generated method stub
		return "This is a memory with s/n:" + getSerialNumber();
	}

	@Override
	public Assortment Clone() {
		// TODO Auto-generated method stub
		return null;
	}
	public Memory(){
		
	}
}

