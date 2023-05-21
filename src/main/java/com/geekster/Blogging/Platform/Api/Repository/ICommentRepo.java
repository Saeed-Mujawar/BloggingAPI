package com.geekster.Blogging.Platform.Api.Repository;

import com.geekster.Blogging.Platform.Api.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends CrudRepository<Comment,Long> {
}
