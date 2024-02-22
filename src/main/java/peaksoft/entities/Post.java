package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.repository.CommentRepo;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(generator = "post_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "post_gen",sequenceName = "post_seq",allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private LocalDate createsAt;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post")
    private List<Comment>comments;
    @OneToMany(mappedBy = "post",cascade = CascadeType.PERSIST)
    private List<Image>images;
    @OneToMany(mappedBy = "post")
    private List<Like>likes;
}
