package com.challenge.LuizaLabs.controller;

import com.challenge.LuizaLabs.model.UserModel;
import com.challenge.LuizaLabs.repository.UserRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class UserController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = {"api/users"}, method = RequestMethod.GET)
    public Object findAllUsers(){
        logger.info("GET: /api/users");
        Object result;
        try {
            if (userRepository.count() == 0){
                result = new ResponseEntity<>("Não há usuários registrados", HttpStatus.NOT_FOUND);
            } else {
                result = new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
            }
        } catch (Exception e){
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/users"}, method = RequestMethod.POST)
    public Object createUser(@RequestBody UserModel userData){
        logger.info("POST: /api/users");
        Object result;
        try {
            result = new ResponseEntity<>(userRepository.save(userData), HttpStatus.CREATED);
        } catch (Exception e){
            result = new ResponseEntity<>("Não foi possível registrar o usuário", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }
}
