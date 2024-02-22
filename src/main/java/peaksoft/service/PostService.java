package peaksoft.service;

import org.springframework.stereotype.Repository;
import peaksoft.entities.Post;

@Repository

public interface PostService {
    public String savePost(Long userId, Post post,String image);
}
