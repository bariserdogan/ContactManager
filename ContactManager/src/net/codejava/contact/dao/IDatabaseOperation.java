package net.codejava.contact.dao;
import java.util.List;
import net.codejava.contact.model.Contact;

public interface IDatabaseOperation {

	public Contact get(int id);
	
	public List<Contact> list();

	public int save(Contact contact);
	
	public int update(Contact contact);
	
	public int delete(int id);
	
}
