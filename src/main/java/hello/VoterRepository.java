package hello;

import org.springframework.data.repository.CrudRepository;

public interface VoterRepository extends CrudRepository<Voter, Long>{

	Voter findByEmailAndPassword(String email, String password);
}
