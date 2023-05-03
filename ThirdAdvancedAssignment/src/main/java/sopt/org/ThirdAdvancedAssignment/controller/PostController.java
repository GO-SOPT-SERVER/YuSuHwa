package sopt.org.ThirdAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.PostCreatRequestDto;
import sopt.org.ThirdAdvancedAssignment.service.PostService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createPost(@RequestBody @Valid final PostCreatRequestDto request){
        System.out.println("게시글 생성 컨트롤러");

        System.out.println(request.toString());

        return postService.creatPost(request);
    }

}
