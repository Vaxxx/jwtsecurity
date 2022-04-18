package ng.com.createsoftware.jwtsecurity.service;

import ng.com.createsoftware.jwtsecurity.entity.Role;
import ng.com.createsoftware.jwtsecurity.entity.User;
import ng.com.createsoftware.jwtsecurity.repository.RoleRepository;
import ng.com.createsoftware.jwtsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
       Role role = roleDao.findByRoleName("User");
        System.out.println("Role : " + role);
       Set<Role> roles = new HashSet<>();
       roles.add(role);
        System.out.println("Roles: " + roles);
        user.setRoles(roles);///this adds the role and into the user_role table
       user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    //auto create roles everytime
    public void initRolesAndUser(){
        //create admin role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("First Hierarchy of Authorization: The Admin Privilege");
        roleDao.save(adminRole);
        //create user role
        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Last Hierarchy of Authorization: Default Role for Users");
        roleDao.save(userRole);

        //create User1
        User user1 = new User();
        user1.setUserFirstName("Vakpo");
        user1. setUserLastName("Okagbare");
        user1.setUserName("Vax");
        user1.setUserPassword(getEncodedPassword("12345678"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        user1.setRoles(adminRoles);
        userDao.save(user1);


        //create User2
        User user2 = new User();
        user2.setUserFirstName("Vax");
        user2. setUserLastName("Bare");
        user2.setUserName("Vaxxinate");
        user2.setUserPassword(getEncodedPassword("12345678"));
        Set<Role>userRol = new HashSet<>();
        userRol.add(userRole);
        user2.setRoles(userRol);
        userDao.save(user2);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
