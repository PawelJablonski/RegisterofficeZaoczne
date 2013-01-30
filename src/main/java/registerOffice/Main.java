package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.orders.Assortment;
import registerOffice.businessObjects.orders.GraphicCards;
import registerOffice.businessObjects.orders.Mainboards;
import registerOffice.businessObjects.orders.Memory;
import registerOffice.businessObjects.orders.Processors;
import registerOffice.businessObjects.persons.*;
import registerOffice.management.*;
import registerOffice.management.conditions.Condition;
import registerOffice.management.conditions.GetByNameCondition;
import registerOffice.management.conditions.GetBySecondName;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		//stwórzmy kilku klientów...
		Customer adam = new Customer("Adam", "Nowicki");
		Customer jan = new Customer("Jan", "Kowalski");
		Customer kasia = new Customer("Katarzyna", "Nowa");
		
		//...kilka kart graficznych...
		Assortment gf650 = new GraphicCards("1234AB","GeForce 650");
		Assortment gf660 = new GraphicCards("1324AB","GeForce 660");
		Assortment radeon7990 = new GraphicCards("1234AB","Radeon 7990");
		
		//...pamięci...
		Assortment gram4= new Memory("GR123", "GoodRam 4GB");
		Assortment gram8 = new Memory("GR223", "GoodRam 8GB");
		Assortment geil16 = new Memory("GL124891", "Geil 16GB");
		
		//...płyt głównych...
		Assortment gbyte = new Mainboards("gb12348","GA-H61M-S2PV");
		Assortment gbyte2 = new Mainboards("gb54348","GA-H61M-S2PV");
		Assortment msi = new Mainboards("m128038","B75MA-E33");
		
		//...oraz procesorów
		Assortment i7 = new Processors("il128473", "core i7");
		Assortment i5 = new Processors("il147673", "core i5");
		Assortment i3 = new Processors("il84473", "core i3");
		
		
		//robimy zakupy
		//adam kupi zestaw na bogato
		
		radeon7990.setOwner(adam);
		i7.setOwner(adam);
		geil16.setOwner(adam);
		gbyte.setOwner(adam);
		
		adam.getMyOrders().add(radeon7990);
		adam.getMyOrders().add(i7);
		adam.getMyOrders().add(geil16);
		adam.getMyOrders().add(gbyte);
		
		//jan czasem w coś pogra
		gf660.setOwner(jan);
		i5.setOwner(jan);
		gram8.setOwner(jan);
		gbyte2.setOwner(jan);
		
		jan.getMyOrders().add(gf660);
		jan.getMyOrders().add(i5);
		jan.getMyOrders().add(gram8);
		jan.getMyOrders().add(gbyte2);
		
		//kasia woli posiedzieć w necie
		gf650.setOwner(kasia);
		i3.setOwner(kasia);
		gram4.setOwner(kasia);
		msi.setOwner(kasia);
		
		kasia.getMyOrders().add(gf650);
		kasia.getMyOrders().add(i3);
		kasia.getMyOrders().add(gram4);
		kasia.getMyOrders().add(msi);
		
		//idziemy do kasy

		session.beginTransaction();
		
		session.save(gf650);
		session.save(gf660);
		session.save(radeon7990);
		
		session.save(gram4);
		session.save(gram8);
		session.save(geil16);
		
		session.save(gbyte);
		session.save(gbyte2);
		session.save(msi);
		
		session.save(adam);
		session.save(jan);
		session.save(kasia);
		
		session.getTransaction().commit();
		session.close();
		
		
		
//		ManagerInterface<Person> mgr= new HsqlPersonManager();
//		
////		ManagerInterface<Person> mgr= new PersonManager();
////		
//		mgr.save(new Person("Adam","1234","Gdańsk"));
//		mgr.save(new Person("Paweł","12345","Elbląg"));
//		mgr.save(new Person("Michał","12344","Gdańsk"));
//		mgr.save(new Person("Ola","1234534","Gdynia"));
//		mgr.save(new Person("Ania","1236544","Sopot"));
//		mgr.save(new Person("Adam","12342","Sopot"));
//		mgr.save(new Person("Adam","12344","Gdańsk"));
//		mgr.save(new Person("Adam","12354","Gdynia"));
////		
//		for(Person p: mgr.getAll())
//			System.out.println(p.getName());
//		
//		Condition<Person> byname=new GetByNameCondition("Adam");
//		Condition<Person> byaddress=new GetByAddressCondition("Sopot");
//		Condition<Person> mainCondition=new Condition<Person>()
//				{
//					@Override
//					protected boolean check(Person obj) {
//						return true;
//					}};
//		
//		byname.setCondition(byaddress);
//		mainCondition.setCondition(byname);
//		for(Person p:mgr.getAll(mainCondition))
//		{
//			System.out.println(p.getName()
//					+" "
//					+p.getAddress()
//					+" "+ p.getPesel());
//		}
//		
	}

}
