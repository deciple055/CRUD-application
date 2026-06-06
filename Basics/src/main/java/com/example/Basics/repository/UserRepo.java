package com.example.Basics.repository;

import com.example.Basics.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserEntry, ObjectId> {
    UserEntry findByUsername(String username);
}
