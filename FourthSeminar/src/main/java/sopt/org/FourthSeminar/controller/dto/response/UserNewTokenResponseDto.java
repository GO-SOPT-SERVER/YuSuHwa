package sopt.org.FourthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserNewTokenResponseDto {
    private String accessToken;
    public static UserNewTokenResponseDto of( String accessToken) {
        return new UserNewTokenResponseDto( accessToken);
    }
}


