package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follower {
    @Id
    @GeneratedValue(generator = "follower_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "follower_gen",sequenceName = "follower_seq",allocationSize = 1)
    private Long id;
    @ElementCollection
    private List<Long> subscribers ;
    @ElementCollection
    private List<Long> subscriptions;
    @OneToOne
    private User user;
}
