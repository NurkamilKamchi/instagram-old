package peaksoft.repository;

import org.springframework.stereotype.Repository;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import peaksoft.entities.Post;

@Repository
public interface PostRepo {
    public String savePost(Long userId, Post post,String image);
}
