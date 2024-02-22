package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Post;
import peaksoft.repository.PostRepo;
import peaksoft.service.PostService;

@Repository
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    @Override
    public String savePost(Long userId, Post post,String image) {
        return postRepo.savePost(userId,post,image);
    }
}
