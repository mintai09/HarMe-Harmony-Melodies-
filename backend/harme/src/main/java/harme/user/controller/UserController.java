package harme.user.controller;

import harme.user.dto.UserRequestDto;
import harme.user.dto.UserResponseDto;
import harme.user.entity.UserEntity;
import harme.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User-Controller", description = "유저 등록 API")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "유저 로그인", description = "기존에 회원가입한 정보를 입력해 로그인")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userRequestDto) {
        Optional<UserEntity> user = userService.login(userRequestDto);
        return user.map(
                userEntity ->
                        ResponseEntity.ok(new UserResponseDto(String.valueOf(userEntity.getId()), userEntity.getNickName())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/signup")
    @Operation(summary = "유저 등록", description = "닉네임과 패스워드를 통해 유저 등록")
    public ResponseEntity<UserResponseDto> generate(@RequestBody UserRequestDto userRequestDto) {
        log.info("Generating user = {}", userRequestDto.getNickName());

        userService.join(userRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/duplicate")
    @Operation(summary = "닉네임 중복 조회", description = "닉네임을 query parameter 로 받아 중복 조회")
    public ResponseEntity<?> duplicate(String nickName) {
        log.info("Duplicating nickName = {}", nickName);


        if (userService.findNickname(nickName)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}