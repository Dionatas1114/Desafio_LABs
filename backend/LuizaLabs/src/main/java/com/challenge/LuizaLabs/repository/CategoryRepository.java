package com.challenge.LuizaLabs.repository;

import com.challenge.LuizaLabs.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {

    @Override
    boolean existsById(Long id);

    @Override
    Optional<CategoryModel> findById(Long id);

    @Override
    void deleteById(Long id);

}
