package asw.DBRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import asw.Model.Voter;

@Component("repo")
public interface VoterRepository extends CrudRepository<Voter, Long>{

	Voter findByEmailAndPassword(String email, String password);
}
