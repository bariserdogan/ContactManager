package net.codejava.contact.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;  


import net.codejava.contact.model.Contact;

public class ContactDao implements IDatabaseOperation {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//public ContactDao(DriverManagerDataSource dataSource){
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
	//}
	
	@Override
	public Contact get(int id) {
		String sql = "Select * from Contact Where contact_id=" +id;
		
		ResultSetExtractor<Contact> extractor  =new ResultSetExtractor<Contact>() {
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					
					return new Contact(id, name, email, address, phone);
				}
				return null;
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public List<Contact> list() {
		return jdbcTemplate.query("select * from contact",new RowMapper<Contact>(){  
		    @Override  
		    public Contact mapRow(ResultSet rs, int rownumber) throws SQLException {  
			    	int id = Integer.parseInt(rs.getString("contact_id").toString()); 
			    	String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					
					return new Contact(id, name, email, address, phone);
		    	}  
		    });  
		}  


	@Override
	public int save(Contact c) {
		String sql = "Insert into Contact(name, email, address, phone) values (?,?,?,?)";
		return  jdbcTemplate.update(sql, c.getName(),c.getEmail(), c.getAddress(), c.getPhone());
		
	}

	@Override
	public int update(Contact c) {
		String sql = "Update Contact set name=?, email=?, address=?, phone=? Where contact_id=?";
		return  jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone(), c.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "Delete from Contact where contact_id="+id;
		return jdbcTemplate.update(sql);
	}

}
