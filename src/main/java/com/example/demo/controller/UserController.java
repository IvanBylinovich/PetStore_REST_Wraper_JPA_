package com.example.demo.controller;

import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<?> registration (@RequestBody User user){

        try {
            Token token = userService.registration(user);
            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

        @GetMapping("/login")
        public ResponseEntity<?> login(@RequestBody Token token){
            try{
                userService.login(token);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch (RuntimeException e){
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        }

        @GetMapping("/logout")
        public ResponseEntity<?> logout(@RequestBody Token token){
            try {
                userService.logout(token);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }catch(RuntimeException e){
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        }

    @PostMapping("/saveUsers")
    public ResponseEntity<?> registrations (@RequestBody List<User> users){
        try{
            userService.saveAll(users);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete (String username){
        try{
            userService.deleteUserByUsername(username);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<?> getByUsername (String username){
        try{
            return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity<?> UpDate (@Valid @RequestBody User user){
        try {
            userService.upUsersDate(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



}
