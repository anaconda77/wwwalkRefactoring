package wwwalk.wwwalk.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Route {

    @Id @GeneratedValue
    @Column(name = "route_id")
    private Long id;
    private String name;
    @Column(name = "start_point_x")
    private double startPointX;
    @Column(name = "start_point_y")
    private double startPointY;
    @Column(name = "end_point_x")
    private double endPointX;
    @Column(name = "end_point_y")
    private double endPointY;
    private LocalDateTime duration;
    private int length;
    @Column(name = "music_url")
    private String musicUrl;
    private LocalDateTime rDate;
    private State security;
    private List<String> tags;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Route(String name, double startPointX, double startPointY, double endPointX, double endPointY
            , LocalDateTime duration, int length, String musicUrl, LocalDateTime rDate, State security, User user) {
        this.name = name;
        this.startPointX = startPointX;
        this.startPointY = startPointY;
        this.endPointX = endPointX;
        this.endPointY = endPointY;
        this.duration = duration;
        this.length = length;
        this.musicUrl = musicUrl;
        this.rDate = rDate;
        this.security = security;
        this.user = user;
    }

    public Route(Long id, String name, State security) {
        this.id = id;
        this.name = name;
        this.security = security;
    }
}
