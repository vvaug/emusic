package br.com.vvaug.repository;

import br.com.vvaug.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
