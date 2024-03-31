package wwwalk.wwwalk.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import wwwalk.wwwalk.controller.MemberJoinForm;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "userinfo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer distance;
    private State state;
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreatedDate
    @Column(updatable = false, name = "created_date")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;


    public Member(MemberJoinForm memberJoinForm) {
        this.username = memberJoinForm.getUsername();
        this.password = memberJoinForm.getPassword();
        this.imageUrl = memberJoinForm.getImageUrl();
        this.state = State.PUBLIC;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public Member(String username, String password, String name, String imageUrl, Integer distance, State state, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.username = username;
        this.password = password;
        this.imageUrl = imageUrl;
        this.distance = distance;
        this.state = state;
        this.role = Role.NOT_PERMITTED;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String hashedPw) {
        this.password = hashedPw;
    }
}
