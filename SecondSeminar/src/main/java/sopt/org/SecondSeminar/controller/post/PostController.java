package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.PostRegisterRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.service.post.PostService;
import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;
import java.util.Objects;
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public String reigster(@RequestBody final PostRegisterRequestDto request){
        System.out.println("제목 : "+request.getTitle());
        System.out.println("내용 : "+request.getContent());
        System.out.println("유저 : "+request.getUserName());

        //서비스 계층에 글를 등록하는 메서드를 호출
        Long postId = postService.register(request);
        if(postId.equals(new Long(-999))) return "해당 유저가 없습니다";
        System.out.println(postList.get(postId.intValue() - 1).toString());


        return postId + "번 글 등록이 완료되었습니다.";
    }

    @GetMapping("/post/{postID}")
    public String getPost(@PathVariable final Long postID){
        System.out.println("요청 포스트 아이디 "+postID);

        //서비스 계층에 글을 찾는 메서드 호출
        Post post = postService.getPostById(postID);
        if (Objects.isNull(post)){
            return "글 조회 실패";
        }
        return post.toString()+"\n글 조회 성공";
    }

    @GetMapping("/post/search")
    public String searchPost(@RequestParam final String title){
        System.out.println("글 제목 검색 인자 : "+title);
        //서비스 계층에 글을 검색하는 메서드 호출
        Post post = postService.getPostByTitle(title);

        if (Objects.isNull(post)){
            return "글 검색 실패";
        }
        return post.toString()+"\n 글 검색 성공";


    }
}
