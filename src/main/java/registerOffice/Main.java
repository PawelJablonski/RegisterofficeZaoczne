package registerOffice;

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
		
		FillDatabaseWithTestValues test = new FillDatabaseWithTestValues();
		test.Run(session);
		
		GetOrders orders = new GetOrders();
		orders.viewAllOrders(session);
		
	
	}

}
