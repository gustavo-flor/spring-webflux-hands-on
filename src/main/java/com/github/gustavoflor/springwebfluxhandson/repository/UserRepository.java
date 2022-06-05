package com.github.gustavoflor.springwebfluxhandson.repository;

import com.github.gustavoflor.springwebfluxhandson.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
