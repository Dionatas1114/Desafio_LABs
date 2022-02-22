package com.challenge.LuizaLabs.repository;

import com.challenge.LuizaLabs.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Id> {

    @Override
    boolean existsById(Id id);

    @Override
    Optional<ProductModel> findById(Id id);

    @Override
    void deleteById(Id id);

}
