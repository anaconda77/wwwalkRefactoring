package wwwalk.wwwalk.entity;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("관리자"), USER("일반 사용자"), NOT_PERMITTED("인증 대기 사용자");

    private String description;

    Role(String description) {
        this.description = description;
    }
}
