package com.emadd9.rest.webservices.restfulwebservice01.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> showAllUsers(){
        return userDaoService.findAll();
    }
    @GetMapping("/users/{id}")
    public User showUserById(@PathVariable int id){
        User user = userDaoService.findById(id);
        if(user == null){
          throw new UserNotFoundException("id: "+id);
        }
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
