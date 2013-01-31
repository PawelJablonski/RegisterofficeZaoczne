package registerOffice.businessObjects.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import registerOffice.businessObjects.persons.Customer;
@Entity
public class Mainboards extends Assortment{

	//pole statyczne
	public Mainboards()
	{
		
	}
	//pola prywatne
	@Override
	public String getAssortmentDetails() {
		// TODO Auto-generated method stub
		return "This is a mainboard with s/n:" + getSerialNumber();
	}

	public Mainboards(String serialNumber, String model) {
		super(serialNumber, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Assortment Clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
