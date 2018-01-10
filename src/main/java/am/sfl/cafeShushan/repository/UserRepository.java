package am.sfl.cafeShushan.repository;

import am.sfl.cafeShushan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Shushi on 1/9/2018.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
}
