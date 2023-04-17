package sopt.org.SecondSeminar.domain.post;

import lombok.Getter;
import sopt.org.SecondSeminar.domain.user.User;

@Getter
public class Post {
    private long id;
    private String title;
    private String content;
    private User user;

    public Post(String title, String content, User user){
        this.title=title;
        this.content=content;
        this.user=user;
    }

    public void setId(Long id){ this.id=id;}
}
