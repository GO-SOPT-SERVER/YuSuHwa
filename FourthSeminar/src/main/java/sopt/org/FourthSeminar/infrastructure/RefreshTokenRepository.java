package sopt.org.FourthSeminar.infrastructure;

import org.springframework.data.repository.CrudRepository;
import sopt.org.FourthSeminar.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    // @Indexed 사용한 필드만 가능
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
