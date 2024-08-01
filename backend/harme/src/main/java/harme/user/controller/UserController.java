package harme.user.controller;

import harme.user.dto.UserDto;
import harme.user.dto.UserResponseDto;
import harme.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User-Controller", description = "유저 등록 API")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "유저 로그인", description = "기존에 회원가입한 정보를 입력해 로그인")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserDto userDto) {
        if(userService.login(userDto).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new UserResponseDto(userDto.getNickName()));
    }

    @PostMapping("/signup")
    @Operation(summary = "유저 등록", description = "닉네임과 패스워드를 통해 유저 등록")
    public ResponseEntity<UserResponseDto> generate(@RequestBody UserDto userDto) {
        log.info("Generating user = {}", userDto.getNickName());

        userService.join(userDto);
        return ResponseEntity.ok(new UserResponseDto(userDto.getNickName()));
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