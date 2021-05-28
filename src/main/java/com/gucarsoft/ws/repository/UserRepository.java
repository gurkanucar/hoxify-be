package com.gucarsoft.ws.repository;

import com.gucarsoft.ws.model.user.User;
import com.gucarsoft.ws.service.user.UserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findAllByUsername(String username);

    @Query(value="Select u from User u")
    Page<UserProjection> getAllUsersProjection(Pageable pabe);

}
