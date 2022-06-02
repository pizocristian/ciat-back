package uniajc.edu.spep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.edu.spep.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
