package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Image;
import peaksoft.entities.Post;
import peaksoft.entities.User;
import peaksoft.repository.PostRepo;
@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepoImpl implements PostRepo {
    private final EntityManager entityManager;
    @Override
    public String savePost(Long userId, Post post,String image) {
        User user = entityManager.find(User.class, userId);
        Image image1 = new Image();
        for (Image postImage : post.getImages()) {
            image1 = postImage;
            postImage.setImageUrl(image);
        }
        user.getPosts().add(post);
        post.setUser(user);
        entityManager.persist(image1);
        entityManager.persist(post);
        return "success!!!";
    }
}
