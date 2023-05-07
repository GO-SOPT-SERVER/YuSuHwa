package sopt.org.ThirdAdvancedAssignment.domain;

import lombok.*;
import  javax.persistence.*;


import sopt.org.ThirdAdvancedAssignment.domain.User;
@Entity
@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성을 DB에 위임. myql의 경우 auto_increment를 사용해 기본기 생성
    @Column(name="POST_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String content;

    @Builder
    public Post(User user, String title,String content){
        this.user = user;
        this.title=title;
        this.content=content;
    }

}
