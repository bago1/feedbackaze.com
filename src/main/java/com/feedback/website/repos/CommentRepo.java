package com.feedback.website.repos;

import com.feedback.website.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {

     @Transactional
     void deleteAllCommentsByTargetEntityId(int id);

     @Transactional
     void deleteAllCommentsByUserEntityId(int id);
}
