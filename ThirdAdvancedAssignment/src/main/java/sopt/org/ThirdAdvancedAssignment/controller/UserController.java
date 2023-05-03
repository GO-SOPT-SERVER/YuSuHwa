package sopt.org.ThirdAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.user.UserCreateRequestDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.user.UserGetResponseDto;
import sopt.org.ThirdAdvancedAssignment.service.UserService;

import javax.validation.Valid;



import org.springframework.http.HttpStatus;
import sopt.org.ThirdAdvancedAssignment.common.dto.ApiResponseDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.user.UserCreateResponseDto;
import sopt.org.ThirdAdvancedAssignment.exception.SuccessStatus;



@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserCreateResponseDto> create(@RequestBody @Valid final UserCreateRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<UserGetResponseDto> getUserById(@PathVariable final Long userId){
        return ApiResponseDto.success(SuccessStatus.GETUSER_SUCCESS, userService.getUserById(userId));
    }

}
