package ng.com.createsoftware.jwtsecurity.repository;

import ng.com.createsoftware.jwtsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByRoleName(String name);
}
