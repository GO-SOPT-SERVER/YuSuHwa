package sopt.org.ThirdAdvancedAssignment.controller.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostGetResponseDto {
    private Long postId;
    private String title;
    private String content;
    private Long userId;
    private String userNickname;

    public static PostGetResponseDto of(Long postId, String title, String content, Long userId, String userNickname){
        return new PostGetResponseDto(postId,title,content,userId,userNickname);
    }
}
