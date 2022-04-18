package ng.com.createsoftware.jwtsecurity.service;

import ng.com.createsoftware.jwtsecurity.entity.Role;
import ng.com.createsoftware.jwtsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleDao;

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
