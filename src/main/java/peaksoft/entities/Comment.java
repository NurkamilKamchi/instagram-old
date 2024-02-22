package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(generator = "comment_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "comment_gen",sequenceName = "comment_seq",allocationSize = 1)
    private Long id;
    private String comment;
    private LocalDate createdAt;
    @ManyToOne
    private Post post;
    @OneToMany(mappedBy = "comment")
    private List<Like>likes;
    @ManyToOne()
    private User user;
}
