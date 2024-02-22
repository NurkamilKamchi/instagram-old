package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_infos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(generator = "user_info_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_info_gen",sequenceName = "user_info_seq",allocationSize =1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String biography;
    private Gender gender;
    private String image;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private User user;

}
