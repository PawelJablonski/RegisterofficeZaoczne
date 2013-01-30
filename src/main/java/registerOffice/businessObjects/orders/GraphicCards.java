package registerOffice.businessObjects.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import registerOffice.businessObjects.persons.Customer;

@Entity
public class GraphicCards extends Assortment{
	
	public GraphicCards(String serialNumber, String model)
	{
		super(serialNumber, model);
	}

	@Override
	public String getAssortmentDetails() {
		// TODO Auto-generated method stub
		return "This is a graphic card with s/n:" + getSerialNumber();
	}

	@Override
	public Assortment Clone() {
		// TODO Auto-generated method stub
		return null;
	}

}

