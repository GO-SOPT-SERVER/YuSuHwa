package sopt.org.FourthSeminar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.FourthSeminar.common.dto.ApiResponse;
import sopt.org.FourthSeminar.controller.dto.request.UserRequestDto;
import sopt.org.FourthSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.FourthSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.FourthSeminar.controller.dto.response.UserResponseDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.service.AuthService;
import sopt.org.FourthSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "유저 API Document")
public class UserController {

    private final UserService userService;
    private final AuthService authService;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "유저 생성 API", description = "유저를 서버에 등록합니다.")
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "유저 로그인 API", description = "유저를 로그인합니다. 즉 유저의 accessToken과 refreshToken을 발급합니다.")
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request); //존재하는 유저인지 확인
        // refreshToken 발급
        final String refreshToken = authService.generateRefreshToken(userId);

        // accessToken발금
        final String accessToken = authService.generateAccessToken(refreshToken);

        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, accessToken,refreshToken));
    }
}
