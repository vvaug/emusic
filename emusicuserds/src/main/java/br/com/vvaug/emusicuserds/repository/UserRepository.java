package br.com.vvaug.emusicuserds.repository;

import br.com.vvaug.emusicuserds.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByUsername(String username);
}
