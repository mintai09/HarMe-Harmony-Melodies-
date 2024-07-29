package harme.user.service;

import harme.user.dto.UserDto;
import harme.user.entity.UserEntity;
import harme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void join(UserDto userDto) {
        UserEntity user = UserEntity.builder()
                .nickName(userDto.getNickName())
                .password(userDto.getPassword())
                .build();

        userRepository.save(user);
    }

    public boolean findNickname(String nickName) {
        return userRepository.findByNickname(nickName).isEmpty();
    }
}
