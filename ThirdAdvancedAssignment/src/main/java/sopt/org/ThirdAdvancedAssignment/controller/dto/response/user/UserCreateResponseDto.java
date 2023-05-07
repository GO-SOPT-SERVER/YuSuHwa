package sopt.org.ThirdAdvancedAssignment.controller.dto.response.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCreateResponseDto {

    private Long userId;
    private String nickname;

    public static UserCreateResponseDto of(Long userId, String nickname) { //각 계층의 dto를 변환해줌
        return new UserCreateResponseDto(userId, nickname);
    }
}