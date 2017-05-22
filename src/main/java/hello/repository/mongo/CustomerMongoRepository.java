package hello.repository.mongo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.model.Customer;

@Repository
public interface CustomerMongoRepository extends CrudRepository<Customer, String> {

}
