package com.challenge.LuizaLabs.controller;

import com.challenge.LuizaLabs.repository.ProductRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = {"api/products"}, method = RequestMethod.GET)
    public Object findAllProducts(){
        logger.info("GET: /api/products");
        Object result;
        try {
            if (productRepository.count() == 0){
                result = new ResponseEntity<>("Não há produtos Registrados", HttpStatus.NOT_FOUND);
            } else {
                result = new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
            }
        } catch (Exception e){
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }
}
