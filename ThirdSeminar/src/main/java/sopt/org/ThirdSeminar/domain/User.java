package sopt.org.ThirdSeminar.domain;

import lombok.*;

import javax.persistence.*;

@Entity //이 클래스를 엔티티로 사용하겠다

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id //이 컬럼이 식별자다
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder //생성자의 가독성을 높여줌
    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}