package registerOffice.businessObjects.persons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import registerOffice.Context;
import registerOffice.businessObjects.orders.*;


@Entity
@Table(name = "Klienci")
/*
@NamedQueries({
	@NamedQuery(
			name="Person.all",
			query="from Person p"
			),
	@NamedQuery(
			name="Person.id",
			query="from Person p where id= :id"
			),
	@NamedQuery(
			name="Person.delete",
			query="Delete from Person p where id=:id"
			)
})*/
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="Imie")
	private String name;
	
	@Column(name="Nazwisko")
	private String secondName;
	
	@OneToMany(cascade=CascadeType.ALL)
	Collection<Assortment> myOrders = new ArrayList<Assortment>();
	
	@Transient
	Context context;
	
	public Customer(String name, String secondName)
	{
		this.name=name;
		this.secondName=secondName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public Collection<Assortment> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(Collection<Assortment> myOrders) {
		this.myOrders = myOrders;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
		//context.reducePeople();
		super.finalize();
	}
	
}
