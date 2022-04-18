package ng.com.createsoftware.jwtsecurity.controller;

import ng.com.createsoftware.jwtsecurity.entity.User;
import ng.com.createsoftware.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user)
    {

        return userService.registerNewUser(user);
    }
    //call the initializing method for dreating users and roles
//    @PostConstruct
//    public void initRolesAndUsers(){
//        userService.initRolesAndUser();
//    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only Accessible to people With Admin Privileges";
    }

    @GetMapping("/forUser")
    //@PreAuthorize("hasRole('User')")
    @PreAuthorize("hasAnyRole('User', 'Admin')")
    public String forUser(){
        return "This URL is only Accessible to people With User Privileges";
    }
}
