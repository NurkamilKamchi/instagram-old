package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(generator = "like_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "like_gen",sequenceName = "like_seq",allocationSize = 1)
    private Long id;
    private boolean isLike;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Comment comment;
    @OneToOne
    private User user;
}
