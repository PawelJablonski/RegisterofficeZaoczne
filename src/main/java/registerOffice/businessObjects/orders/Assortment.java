package registerOffice.businessObjects.orders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;



import registerOffice.Context;
import registerOffice.businessObjects.persons.Customer;

@Entity
@Table(name="Asortyment")
public abstract class Assortment implements AssortmentInterface{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="SN")
	protected String serialNumber;
	
	@Column(name="Model")
	protected String model;

	public Customer getOwner() {
		return owner;
	}

	@ManyToOne
	private Customer owner;
	
public void setOwner(Customer owner) {
		this.owner = owner;
	}
	public Assortment()
	{
		
	}
	//	@Transient
//	Context context;
	public Assortment(String serialNumber, String model){
//		context =Context.getInstance();
//		context.raiseNumberOfOrders();

		this.serialNumber = serialNumber;
		this.model = model;
	}

	public void printData()
	{
		System.out.println("Owner: "+((Customer) owner).getName());
		System.out.println(getAssortmentDetails());
	}
	
	public abstract String getAssortmentDetails();
	
	public abstract Assortment Clone();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	protected void finalize() throws Throwable {
//		context.reduceOrders();
		super.finalize();
	}
	
}
