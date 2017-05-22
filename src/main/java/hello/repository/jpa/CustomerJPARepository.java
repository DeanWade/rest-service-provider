package hello.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJPARepository extends CrudRepository<CustomerJPA, String> {
	
}
