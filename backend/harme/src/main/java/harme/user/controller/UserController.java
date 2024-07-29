package harme.user.controller;

import harme.user.dto.UserDto;
import harme.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> generate(UserDto userDto) {
        log.info("Generating user = {}", userDto.getNickName());
        userService.join(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/duplecate")
    public ResponseEntity<?> duplicate(String nickName) {
        log.info("Duplicating nickName = {}", nickName);

        if (userService.findNickname(nickName)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}