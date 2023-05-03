package sopt.org.ThirdAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdAdvancedAssignment.common.dto.ApiResponseDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.post.PostCreatRequestDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.post.PostGetResponseDto;
import sopt.org.ThirdAdvancedAssignment.exception.SuccessStatus;
import sopt.org.ThirdAdvancedAssignment.service.PostService;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.post.PostCreateResponseDto;
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

    @GetMapping("/post/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<PostGetResponseDto> getPostById(@PathVariable final Long postId){
        return ApiResponseDto.success(SuccessStatus.GETPOST_SUCCESS,postService.getPostById(postId));
    }

}
