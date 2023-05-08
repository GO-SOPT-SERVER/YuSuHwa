package sopt.org.SecondSeminar.controller.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sopt.org.SecondSeminar.domain.user.User;

//  AccessLevel(PUBLIC, PROTECTED, PACKAGE, PRIVATE) 지정을 통해서 접근 레벨도 제한할 수도 있음
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRegisterRequestDto {
    private String title;
    private String content;
    private String userName;
}
