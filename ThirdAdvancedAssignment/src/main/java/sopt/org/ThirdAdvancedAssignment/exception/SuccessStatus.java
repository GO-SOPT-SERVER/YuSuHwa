package sopt.org.ThirdAdvancedAssignment.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {

    /*
    user
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    GETUSER_SUCCESS(HttpStatus.OK, "회원정보 조회를 성공했습니다."),


    /*
    post
     */
    CREATEPOST_SUCCESS(HttpStatus.CREATED,"게시글 생성이 완료되었습니다."),
    GETPOST_SUCCESS(HttpStatus.OK,"게시글 조회를 성공했습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
