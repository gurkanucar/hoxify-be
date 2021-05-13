package com.gucarsoft.ws.repository;

import com.gucarsoft.ws.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findAllByUsername(String username);

}
