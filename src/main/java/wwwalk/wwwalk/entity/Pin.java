package wwwalk.wwwalk.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pin {

    @Id
    @GeneratedValue
    @Column(name="pin_id")
    private Long id;
    private String memo;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    private Point point;

    public Pin(String memo, String imageUrl, Route route, Point point) {
        this.memo = memo;
        this.imageUrl = imageUrl;
        this.route = route;
        this.point = point;
    }
}
