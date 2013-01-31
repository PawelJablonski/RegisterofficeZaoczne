package registerOffice.management;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;

import registerOffice.businessObjects.persons.*;
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

public class GetOrders {

	public void viewAllOrders(Session session){
	
	
	
	
	
	Query query = (Query) session.createQuery("from Customer")
		    .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	List<Customer> list = query.list();
	
	
	for (Customer result : list)
	{
		System.out.println(result.getId()+ " " + result.getName() + " " + result.getSecondName() + "kupił: ");
		Collection<Assortment> zamowienie = result.getMyOrders(); 
		for(Assortment r2 : zamowienie)
		{
			System.out.println("  ->"+r2.getId()+" Model: "+r2.getModel()+" s/n: "+r2.getSerialNumber());
		}
	}
	}
	
}