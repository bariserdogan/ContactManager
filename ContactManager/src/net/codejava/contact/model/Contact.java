package net.codejava.contact.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Contact {
	@NotNull
	private int id;
	
	@NotEmpty(message="Required Field")
	@Size(max=45, message="must be max 45 characters")
	private String name;
	
	@NotEmpty(message="Required Field")
	@Size(max=45, message="must be max 45 characters")
	private String email;
	
	@NotEmpty(message="Required Field")
	@Size(max=100, message="must be max 100 characters")
	private String address;
	
	@NotEmpty(message="Required Field")
	@Size(max=15, message="must be max 15 characters")
	private String phone;
	
	public Contact() {
		
	}
	
	public Contact(int id, String name, String email, String address, String phone) {
		this(name, email, address, phone);
		this.id = id;
	}
	
	public Contact(String name, String email, String address, String phone) {
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Contact[id= "+ id +", name= "+ name +", email= "+ email +", address= "+ address +", phone= "+ phone +" ]";
	}

	
	
	
}
