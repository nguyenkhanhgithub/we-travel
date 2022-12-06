package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Boolean existsPostByPostId(Long postId);
    @Query(value = "select * from post where (account_id = :accountId or 0 = :accountId) and (topic_id in (:topicList) or -1 in (:topicList))\n" +
            " and (is_block = :isBlock or -1 = :isBlock)  and (is_public = :isPublic or -1 = :isPublic)" , nativeQuery = true)
    List<Post> getListPost(Long accountId , Integer isBlock , Integer isPublic , List<Long> topicList , Pageable pageable);

    @Query(value = "select p.* from post p right join report_post rp on p.post_id = rp.post_id where (p.account_id = :accountId or 0 = :accountId) \n" +
            "and (p.topic_id in (:topicList) or -1 in (:topicList)) and (p.is_block = :isBlock or -1 = :isBlock)  and (p.is_public = :isPublic or -1 = :isPublic)" , nativeQuery = true)
    List<Post> getListPostReport(Long accountId , Integer isBlock , Integer isPublic , List<Long> topicList , Pageable pageable);
}
