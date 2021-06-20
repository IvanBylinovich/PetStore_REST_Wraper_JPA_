package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class UserService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    private Map<Long, UUID> tokensKeys = new HashMap<>();

    public void login(Token token)throws RuntimeException{
        if(tokenRepository.existsByKey(token.getKey())){
            tokensKeys.put(token.getId(),token.getKey());
        }else{
            throw new RuntimeException();
        }
    }

    public void logout(Token token)throws RuntimeException{
        if(tokenRepository.existsByKey(token.getKey()) && tokensKeys.containsKey(token.getId())){
            tokensKeys.remove(token.getId(), token.getKey());
        }else{
            throw new RuntimeException();
        }

    }

    public Token registration(User user) throws RuntimeException {

        Address address = addressRepository.save(user.getAddress());
        user.setAddress(address);



        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException();
        }
        User savedUser = userRepository.save(user);
        Token token = new Token();
        token.setUser(savedUser);
        token.setKey(UUID.randomUUID());

        return tokenRepository.save(token);
    }

    public void  saveAll(List<User> users)throws RuntimeException{
        for(User user : users){
            Address address = addressRepository.save(user.getAddress());
            user.setAddress(address);

            if(userRepository.existsByUsername(user.getUsername())){
                throw new RuntimeException();
            }
            userRepository.save(user);
        }
    }

    public void deleteUserByUsername(String username)throws RuntimeException{
        if(userRepository.existsByUsername(username)){
            User user = userRepository.getUserByUsername(username);
            addressRepository.delete(user.getAddress());
            userRepository.delete(user);
        }else {
            throw new RuntimeException();
        }

    }
    public User getUserByUsername(String username)throws RuntimeException{
        Optional<User> foundUser = Optional.ofNullable(userRepository.getUserByUsername(username));
        if(foundUser.isPresent()){
            return foundUser.get();
        }
        throw new RuntimeException();
    }

    public void upUsersDate(User user)throws RuntimeException{
        if(userRepository.existsByUsername(user.getUsername())){
            User oldUser = userRepository.getUserByUsername(user.getUsername());
            oldUser.getAddress().setHome(user.getAddress().getHome());
            oldUser.getAddress().setStreet(user.getAddress().getStreet());
            oldUser.setPassword(user.getPassword());
            oldUser.setName(user.getName());

            addressRepository.save(oldUser.getAddress());
            userRepository.save(oldUser);
        }else{
            throw new RuntimeException();
        }


    }



}
