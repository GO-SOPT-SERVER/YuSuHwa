package sopt.org.ThirdAdvancedAssignment.controller.dto.response.post;
import lombok.AccessLevel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostCreateResponseDto {
    private Long postId;
    private String title;
    private String content;
    private Long userId;
    private String userNickname;

    public static PostCreateResponseDto of(Long postId, String title, String content, Long userId, String userNickname){
        return new PostCreateResponseDto(postId,title,content,userId,userNickname);
    }
}
