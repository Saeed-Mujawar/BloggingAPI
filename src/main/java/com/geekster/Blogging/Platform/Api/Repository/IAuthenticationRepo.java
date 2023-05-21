package com.geekster.Blogging.Platform.Api.Repository;

import com.geekster.Blogging.Platform.Api.model.AuthenticationToken;
import com.geekster.Blogging.Platform.Api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends CrudRepository<AuthenticationToken,Long> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}
