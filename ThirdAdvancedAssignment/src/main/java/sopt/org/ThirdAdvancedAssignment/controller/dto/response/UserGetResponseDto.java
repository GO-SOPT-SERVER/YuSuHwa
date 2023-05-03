package sopt.org.ThirdAdvancedAssignment.controller.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserGetResponseDto {
    private Long userId;
    private String nickname;
    private String email;

    public static UserGetResponseDto of(Long userId, String nickname,String email) {
        return new UserGetResponseDto(userId, nickname,email);
    }
}
