package hello.repository.mongo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import hello.model.Customer;

@Document
public class CustomerMongo extends Customer implements Serializable{
	
	private static final long serialVersionUID = -3037476022129120706L;

//	@Id
//	private String id;
//
//	@Field("first_name")
//	private String firstName;
//	
//	@Field("last_name")
//	private String lastName;

	public CustomerMongo() {
	}

	public CustomerMongo(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	@Id
	public void setId(String id) {
		super.setId(id);
	}

	@Field("last_name")
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}
	
	@Field("last_name")
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}
}
