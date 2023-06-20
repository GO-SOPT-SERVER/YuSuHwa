package sopt.org.FourthSeminar.domain;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash(value = "refreshToken", timeToLive = 60)//60초 뒤 데이터 삭제 -> 실무에서는 2주로 생각
public class RefreshToken {
    @Id
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

