package am.sfl.cafeShushan.repository;

import am.sfl.cafeShushan.entity.Table;
import am.sfl.cafeShushan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Shushi on 1/9/2018.
 */
@Repository("tableRepository")
public interface TableRepository extends JpaRepository<Table, Long> {
	 Table findById(Long id);
	 Table findByUser(User user);
}
