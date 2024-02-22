package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(generator = "image_gen",strategy =GenerationType.SEQUENCE)
    @SequenceGenerator(name = "image_gen",sequenceName = "image_seq",allocationSize = 1)
    private Long id;
    private String imageUrl;
    @ManyToOne
    private Post post;
    //    otmetka
    @OneToMany
    private List<User>users;
}
