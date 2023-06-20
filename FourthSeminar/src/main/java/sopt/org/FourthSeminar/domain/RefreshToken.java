package sopt.org.FourthSeminar.domain;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@RedisHash(value = "refreshToken", timeToLive = 60*60*24*14)//14일후 데이터 삭제
public class RefreshToken {
    @Id
    private String id;
    @Indexed
    private String refreshToken;

    private Long userId;

    public RefreshToken(final String refreshToken, final Long userId){
        this.refreshToken=refreshToken;
        this.userId=userId;
    }

    public String getRefreshToken(){
        return refreshToken;
    }

    public Long getUserId(){
        return userId;
    }
}

