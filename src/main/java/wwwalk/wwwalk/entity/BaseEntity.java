package wwwalk.wwwalk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {




}
