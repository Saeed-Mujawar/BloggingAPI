package com.geekster.Blogging.Platform.Api.Repository;

import com.geekster.Blogging.Platform.Api.model.Post;
import com.geekster.Blogging.Platform.Api.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends CrudRepository<Post,Long> {
    List<Post> findByUser(User user);

    @Modifying
    @Query(value = "update post set post_data= :data where post_id= :postId",nativeQuery = true)
    void updatePost(Long postId, String data);

}
