package com.challenge.LuizaLabs.controller;

import com.challenge.LuizaLabs.model.ProductModel;
import com.challenge.LuizaLabs.repository.ProductRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(path = {"api/products/{id}"}, method = RequestMethod.GET)
    public Object findProduct(@PathVariable("id") Long productId){
        logger.info(String.format("GET: /api/products/%s", productId));
        Object result;
        try {
            Optional<ProductModel> productFind = productRepository.findById(productId);
            if (productFind.isPresent ()){
                result = new ResponseEntity<>(productFind.get(), HttpStatus.OK);
            } else {
                result = new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND); //ProductMessages.ProductNotFound
            }
        } catch (Exception e){
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/products"}, method = RequestMethod.POST)
    public Object createProduct(@RequestBody ProductModel productData){
        logger.info("POST: /api/products");
        Object result;
        try {
            result = new ResponseEntity<>(productRepository.save(productData), HttpStatus.CREATED);
        } catch (Exception e){
            result = new ResponseEntity<>("Não foi possível registrar o produto", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/products/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct( @PathVariable("id") Long productId, @RequestBody ProductModel productData){
        ResponseEntity<String> result;
        logger.info(String.format("UPDATE: /api/products/%s", productId));
        try {
            if (!productRepository.existsById(productId)){
                result = new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
            } else {
                productData.setId(productId);
                productRepository.save(productData);
                result = new ResponseEntity<>("Produto atualizado", HttpStatus.OK);
            }
        } catch (Exception e){
            result = new ResponseEntity<>("Produto não atualizado", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/products/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
        ResponseEntity<String> result;
        logger.info(String.format("DELETE: /api/products/%s", productId));
        try {
            if (!productRepository.existsById(productId)) {
                result = new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
            } else {
                productRepository.deleteById(productId);
                result = new ResponseEntity<>("Produto deletado", HttpStatus.OK);
            }
        } catch (Exception e) {
            result = new ResponseEntity<>("Produto não deletado", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }
}
