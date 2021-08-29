package com.microServices.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserResources {

    @Autowired
    private DaoService service;

    @GetMapping("users")
    public List<User> retrieveAllUsers(){

        return service.findAll() ;
    }

    @GetMapping("users/{id}")
    public User  getUser(@PathVariable Integer id){
        User user = service.GetUserById(id);
            if(user==null){
                // throw  404 Resource Not Found
                throw new  UserNotFoundException("id : " +id);
            }
        // implementing HATEOAS to add link of retrieveAllUsers() methode above

        // "all-uers" , SERVER_PATH + "/users"
        // retrieveAllUsers


//        Resource<User>  resource = new Resource<User>(user);
//       ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//       resource.add(linkBuilder.withRel("all-users"));


       return user;
    }

//    @PostMapping("/users")
//    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
//       User savedUser = service.addUser(user);
//        // Enhancing POST Method to return correct HTTP Status Code and Location
//
////        UriComponentsBuilder with additional static factory methods
////        to create links based on the current HttpServletRequest.
////        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
//
////        ResponseEntity represents the whole HTTP response
////        : status code, headers, and body. As a result, we can
////        use it to fully configure the HTTP response.
//        return ResponseEntity.created().build();
//
//    }

    @DeleteMapping("users/{id}")
    public void  deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user==null){
            // throw  404 Resource Not Found
            throw new  UserNotFoundException("id : " +id);
        }

    }

}
