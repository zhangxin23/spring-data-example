package neo4j;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/** Neo4j repository. */
public interface UserRepository extends GraphRepository<User> {
	
	User findByLogin(String login);
	
	@Query("START root=node:User(login = 'root') MATCH root-[:knows]->friends RETURN friends")
	List<User> findFriendsOfRoot();
	
}
