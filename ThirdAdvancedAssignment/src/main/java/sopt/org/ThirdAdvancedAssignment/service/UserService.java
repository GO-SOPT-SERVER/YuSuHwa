package sopt.org.ThirdAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdAdvancedAssignment.controller.dto.request.user.UserCreateRequestDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.user.UserCreateResponseDto;
import sopt.org.ThirdAdvancedAssignment.controller.dto.response.user.UserGetResponseDto;
import sopt.org.ThirdAdvancedAssignment.domain.User;
import sopt.org.ThirdAdvancedAssignment.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


        @Transactional   //하나의 서비스의 craete 메서드를 트랜잭션으로 묶어서 하나의 원자단위로 보게함.
        public UserCreateResponseDto create(UserCreateRequestDto request) {

            User user = User.builder() //builder 패턴 사용
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        return UserCreateResponseDto.of(user.getId(), user.getNickname());

    }

    public UserGetResponseDto getUserById(Long userId){
            User user = userRepository.findById(userId);
            return UserGetResponseDto.of(user.getId(), user.getNickname(),user.getEmail());
    }

}