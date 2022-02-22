package com.challenge.LuizaLabs.repository;

import com.challenge.LuizaLabs.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, Id> {

    @Override
    boolean existsById(Id id);

    @Override
    Optional<CategoryModel> findById(Id id);

    @Override
    void deleteById(Id id);

}
