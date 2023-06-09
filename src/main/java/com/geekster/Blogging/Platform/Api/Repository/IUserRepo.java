package com.geekster.Blogging.Platform.Api.Repository;

import com.geekster.Blogging.Platform.Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String userEmail);

    User findByUserId(Long myId);
}
