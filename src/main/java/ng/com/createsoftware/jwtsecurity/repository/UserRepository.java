package ng.com.createsoftware.jwtsecurity.repository;

import ng.com.createsoftware.jwtsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
