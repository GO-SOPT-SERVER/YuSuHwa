package sopt.org.ThirdAdvancedAssignment.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {

    private Long userId;
    private String nickname;

    public static UserResponseDto of(Long userId, String nickname) { //각 계층의 dto를 변환해줌
        return new UserResponseDto(userId, nickname);
    }
}