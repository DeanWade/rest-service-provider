package hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, String>{
	
//	@Query("select u from Greeting u where u.content = ?1")
    public Greeting findByContent(String content);
}
