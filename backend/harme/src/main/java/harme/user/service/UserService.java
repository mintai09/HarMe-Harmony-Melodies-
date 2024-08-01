package harme.user.service;

import harme.user.dto.UserRequestDto;
import harme.user.dto.UserResponseDto;
import harme.user.entity.UserEntity;
import harme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void join(UserRequestDto userRequestDto) {
        UserEntity user = UserEntity.builder()
                .nickName(userRequestDto.getNickName())
                .password(userRequestDto.getPassword())
                .build();

        userRepository.save(user);
    }

    public boolean findNickname(String nickName) {
        return userRepository.findByNickname(nickName).isEmpty();
    }

    public Optional<UserEntity> login(UserRequestDto userRequestDto) {
        return userRepository.findByUser(userRequestDto.getNickName(), userRequestDto.getPassword());
    }
}
