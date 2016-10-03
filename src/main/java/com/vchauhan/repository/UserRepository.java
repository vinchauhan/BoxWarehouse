package com.vchauhan.repository;

import com.vchauhan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vineet on 9/12/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findOneByUsername(String username);

}
