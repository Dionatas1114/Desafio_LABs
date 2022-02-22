package com.challenge.LuizaLabs.controller;

import com.challenge.LuizaLabs.model.CategoryModel;
import com.challenge.LuizaLabs.repository.CategoryRepository;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class CategoryController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path = {"api/categories"}, method = RequestMethod.GET)
    public Object findAllCategories(){
        logger.info("GET: /api/categories");
        Object result;
        try {
            if (categoryRepository.count() == 0){
                result = new ResponseEntity<>("Não há categorias Registradas", HttpStatus.NOT_FOUND);
            } else {
                result = new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
            }
        } catch (Exception e){
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/categories/{id}"}, method = RequestMethod.GET)
    public Object findCategory(@PathVariable("id") Long categoryId){
        logger.info(String.format("GET: /api/categories/%s", categoryId));
        Object result;
        try {
            Optional<CategoryModel> categoryFind = categoryRepository.findById(categoryId);
            if (categoryFind.isPresent ()){
                result = new ResponseEntity<>(categoryFind.get(), HttpStatus.OK);
            } else {
                result = new ResponseEntity<>("Categoria não encontrada", HttpStatus.NOT_FOUND); //CategoryMessages.CategoryNotFound
            }
        } catch (Exception e){
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/categories"}, method = RequestMethod.POST)
    public Object createCategory(@RequestBody CategoryModel categoryData){
        logger.info("POST: /api/categories");
        Object result;
        try {
            result = new ResponseEntity<>(categoryRepository.save(categoryData), HttpStatus.CREATED);
        } catch (Exception e){
            result = new ResponseEntity<>("Não foi possível registrar a categoria", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/categories/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<String> updateCategory( @PathVariable("id") Long categoryId, @RequestBody CategoryModel categoryData){
        ResponseEntity<String> result;
        logger.info(String.format("UPDATE: /api/categories/%s", categoryId));
        try {
            if (!categoryRepository.existsById(categoryId)){
                result = new ResponseEntity<>("Categoria não encontrada", HttpStatus.NOT_FOUND);
            } else {
                categoryData.setId(categoryId);
                categoryRepository.save(categoryData);
                result = new ResponseEntity<>("Categoria atualizada", HttpStatus.OK);
            }
        } catch (Exception e){
            result = new ResponseEntity<>("Categoria não atualizada", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(path = {"api/categories/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        ResponseEntity<String> result;
        logger.info(String.format("DELETE: /api/categories/%s", categoryId));
        try {
            if (!categoryRepository.existsById(categoryId)) {
                result = new ResponseEntity<>("Categoria não encontrada", HttpStatus.NOT_FOUND);
            } else {
                categoryRepository.deleteById(categoryId);
                result = new ResponseEntity<>("Categoria deletada", HttpStatus.OK);
            }
        } catch (Exception e) {
            result = new ResponseEntity<>("Categoria não deletada", HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        return result;
    }
}
