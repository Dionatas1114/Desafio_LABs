package com.challenge.LuizaLabs.repository;

import com.challenge.LuizaLabs.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {

    @Override
    boolean existsById(Long id);

    @Override
    Optional<ProductModel> findById(Long id);

    @Override
    void deleteById(Long id);

}
