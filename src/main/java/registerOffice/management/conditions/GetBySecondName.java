package registerOffice.management.conditions;

import registerOffice.businessObjects.persons.Customer;

public class GetBySecondName extends Condition<Customer>{

	private String sName;
	
	public GetBySecondName(String pesel)
	{
		this.sName=pesel;
	}
	
	@Override
	protected boolean check(Customer obj) {
		
		return obj.getSecondName().equalsIgnoreCase(sName);
	}

}
