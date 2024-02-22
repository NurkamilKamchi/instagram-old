package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "user_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen",sequenceName = "user_seq",allocationSize = 1)
    private Long id;
    @Column(name = "user_name",unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Post>posts;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private UserInfo userInfo;

    @OneToOne(mappedBy = "user",cascade = CascadeType.PERSIST)
    private Follower follower;
    @OneToOne
    private Like like;
    @OneToMany(mappedBy = "user")
    private List<Comment>comments;

}
