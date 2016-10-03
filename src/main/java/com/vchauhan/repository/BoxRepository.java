package com.vchauhan.repository;

import com.vchauhan.domain.Box;
import com.vchauhan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vineet on 9/16/16.
 */
@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

    public Box findBoxByUser(User user);

}

