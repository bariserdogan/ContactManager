package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import net.codejava.contact.model.Contact;

class ContactDaoTest {

	private DriverManagerDataSource dataSource;
	private IDatabaseOperation dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("baris");
	 	
		dao = new ContactDao(dataSource);
	}
	
	@Test
	void testGet() {
		int id = 1;
		Contact contact =  dao.get(id);
		if(contact!=null) {
			System.out.println(contact);
		}
		assertNotNull(contact, "Contact was not found");
	}

	@Test
	void testList() {
		List<Contact> contactList = dao.list();
		
		for (Contact contact : contactList) {
			System.out.println(contact);
		}
		
		assertTrue(!contactList.isEmpty());
	}

	@Test
	void testSave() {
		Contact contact = new Contact("mehmet kane Kane", "harry@kane.com", "Tottenham, TH", "123123");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(2,"Bill Thompson", "bill@thompson.com", "Tottenham, TH", "00033033344");
		int result = dao.update(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testDelete() {
		int id = 2;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

}
