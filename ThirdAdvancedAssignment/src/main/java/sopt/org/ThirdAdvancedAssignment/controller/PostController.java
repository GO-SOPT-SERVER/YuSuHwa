package sopt.org.ThirdAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.ThirdAdvancedAssignment.common.dto.ApiResponseDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.PostCreatRequestDto;
import sopt.org.ThirdAdvancedAssignment.exception.SuccessStatus;
import sopt.org.ThirdAdvancedAssignment.service.PostService;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.PostCreateResponseDto;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<PostCreateResponseDto> createPost(@RequestBody @Valid final PostCreatRequestDto request){

        return ApiResponseDto.success(SuccessStatus.CREATEPOST_SUCCESS,postService.creatPost(request));
    }

}
