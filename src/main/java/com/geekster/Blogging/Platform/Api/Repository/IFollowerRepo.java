package com.geekster.Blogging.Platform.Api.Repository;

import com.geekster.Blogging.Platform.Api.model.Follower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowerRepo extends CrudRepository<Follower,Long> {
}
