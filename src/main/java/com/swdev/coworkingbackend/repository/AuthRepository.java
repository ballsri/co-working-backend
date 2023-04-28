package com.swdev.coworkingbackend.repository;

import com.swdev.coworkingbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<User, String> {

    @Query("{'email':?0}")
    User findByEmail(String email);

}
