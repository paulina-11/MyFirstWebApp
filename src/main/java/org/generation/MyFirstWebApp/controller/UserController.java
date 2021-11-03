package org.generation.MyFirstWebApp.controller;

import org.generation.MyFirstWebApp.model.User;
import org.generation.MyFirstWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
        userService.add( new User( 1, "Santiago", "Carrillo" ) );
        userService.add( new User( 2, "Juan", "Sanchez" ) );
        userService.add( new User( 3, "Pedro", "Ortiz" ) );
        userService.add( new User( 4, "Jose", "Pacheco" ) );
        userService.add( new User( 5, "Rodrigo", "Mendez" ) );
        userService.add( new User( 6, "Angel", "Rosas" ) );
    }

    //nombre de usuarios en forma de Json
    @GetMapping( "/user" )
    public User getUser()
    {
        return userService.getUser( 0 );
    }

    //cantidad de usuarios
    @GetMapping("/users/all")
    public int totalUsers()
    {
        return userService.size();
    }
    //todos los usuarios
    @GetMapping("/users/Lists)
    public List<User> getAll()
    {
        return userService.getAll();
    }

}
