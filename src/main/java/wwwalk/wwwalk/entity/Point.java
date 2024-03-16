package wwwalk.wwwalk.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point {

    @Id @GeneratedValue
    @Column(name = "point_id")
    private Long id;
    @Column(name = "point_x")
    private double pointX;
    @Column(name = "point_y")
    private double pointY;
    private LocalDateTime pDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    public Point(double pointX, double pointY, LocalDateTime pDate, Route route) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pDate = pDate;
        this.route = route;
    }
}
