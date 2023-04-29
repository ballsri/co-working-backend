package com.swdev.coworkingbackend.repository;

import com.swdev.coworkingbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    // find user by email
    @Query("{'email':?0}")
    User findByEmail(String email);

    // create a new user
    User save(User user);




}
