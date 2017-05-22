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
	public String getId() {
		return super.getId();
	}

	@Field("first_name")
	public String getFirstName() {
		return super.getFirstName();
	}

	@Field("last_name")
	public String getLastName() {
		return super.getLastName();
	}

}
