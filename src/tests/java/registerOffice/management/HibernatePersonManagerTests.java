package registerOffice.management;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import registerOffice.businessObjects.persons.Customer;

public class HibernatePersonManagerTests {

	
	private HibernatePersonManager mgr;
	private SessionFactory factory;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		factory = 
				new Configuration().configure().buildSessionFactory();
		mgr = new HibernatePersonManager(factory.openSession());
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		Customer result = mgr.get(1);
		Customer result2 = mgr.get(1);
		Customer result3 = mgr.get(100);
		assertNotNull("brak wyników",result);
		assertEquals("zle ustawienie Id",result.getId(),1);
		
		assertEquals("zle ustawienie nazwiska",result.getSecondName(),"Nowicki");
		assertEquals("zle ustawienie imion",result.getName(), "Adam");
		assertNotSame("obiekty nie powinny wskazywac na to samo pole w pamieci",
				result,result2);
		assertNull("nie zwraca null gdy nie ma wyniku w bazie"
				,result3);
		
	}

	@Test
	public void testGetAll() {
		List<Customer> results = mgr.getAll();
		
		assertNotNull("Lista jest nullem", results);
		assertTrue("ilosc elementów w liscie sie nie zgadza",
				results.size()==6);
	}

	@Test
	public void testSave() {
		Customer p = new Customer("Tomasz", "Morski");
		mgr.save(p);
		Customer result = mgr.get(7);
		assertNotNull("nie zapisano do bazy",result);
		assertEquals("zle ustawienie nazwiska",result.getSecondName(),"Morski");
		assertEquals("zle ustawienie imion",result.getName(), "Tomasz");
		
	}

	@Test
	public void testDelete() {
		Customer p = mgr.get(1);
		boolean deleted = mgr.delete(p);
		
		Customer result = mgr.get(1);
		assertTrue("nie skasowano",deleted);
		assertTrue("ilosc danych w bazie nie zmalala",
				mgr.getAll().size()==5);
		
	}

}
