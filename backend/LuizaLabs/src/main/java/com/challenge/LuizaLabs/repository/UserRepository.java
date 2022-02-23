package com.challenge.LuizaLabs.repository;

import com.challenge.LuizaLabs.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByName(String name);

    UserModel findByPassword(String password);

}
