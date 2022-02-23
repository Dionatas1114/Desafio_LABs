package com.challenge.LuizaLabs.controller;

import com.challenge.LuizaLabs.model.UserModel;
import com.challenge.LuizaLabs.repository.UserRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/")
public class LoginController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = {"api/login"}, method = RequestMethod.POST)
    public Object login(@RequestBody UserModel userData){
        logger.info("POST: /api/login");
        Object result;
        try {
            String name = userData.getName ();
            String password = userData.getPassword();

            UserModel userName = userRepository.findByName(name);
            UserModel userPassw = userRepository.findByPassword(password);

            if(Objects.equals(userName.name, name) && Objects.equals(userPassw.password, password)){
                result = new ResponseEntity<>("Bem vindo ao Magalu!", HttpStatus.OK);
            } else {
                result = new ResponseEntity<>("Nome ou senha inválidos", HttpStatus.UNAUTHORIZED);
            }

        } catch (Exception e){
            result = new ResponseEntity<>("Não foi possível realizar o login", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }
}
