package hello.repository.mongo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.model.Customer;

@Repository
public interface CustomerMongoRepository extends CrudRepository<Customer, String>{

	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);
}
