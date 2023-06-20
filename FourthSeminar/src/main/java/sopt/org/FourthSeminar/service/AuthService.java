package sopt.org.FourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.FourthSeminar.config.jwt.JwtService;
import sopt.org.FourthSeminar.domain.RefreshToken;
import sopt.org.FourthSeminar.exception.Error;
import sopt.org.FourthSeminar.exception.model.UnauthorizedException;
import sopt.org.FourthSeminar.infrastructure.RefreshTokenRepository;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;


    // refreshToken 발급 및 재발급
    public String generateRefreshToken(Long userId){
        final String refreshToken = jwtService.issuedRefreshToken();
        RefreshToken redisRefreshToken = new RefreshToken(refreshToken,userId);
        refreshTokenRepository.save(redisRefreshToken);

        return refreshToken;

    }


    // refreshToken으로 accessToken 재발급
    public String generateAccessToken(String refreshToken){
        RefreshToken redisRefreshToken = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new UnauthorizedException(Error.INVALID_REFRESH_TOKEN_EXCEPTION, Error.INVALID_REFRESH_TOKEN_EXCEPTION.getMessage()));

        Long userId = redisRefreshToken.getUserId();

        String accessToken = jwtService.issuedAccessToken(userId);
        return accessToken;
    }




}
