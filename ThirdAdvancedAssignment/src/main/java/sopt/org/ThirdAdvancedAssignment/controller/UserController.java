package sopt.org.ThirdAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.UserRequestDto;
import sopt.org.ThirdAdvancedAssignment.service.UserService;

import javax.validation.Valid;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sopt.org.ThirdAdvancedAssignment.common.dto.ApiResponseDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.UserResponseDto;
import sopt.org.ThirdAdvancedAssignment.exception.SuccessStatus;



@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }
}
