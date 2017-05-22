package hello.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.model.Customer;

@Repository
public interface CustomerJPARepository extends CrudRepository<Customer, String> {
	
}
