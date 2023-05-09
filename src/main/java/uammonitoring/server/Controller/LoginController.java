package uammonitoring.server.Controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uammonitoring.server.Config.security.jwt.TokenDto;
import uammonitoring.server.DTO.LoginRequestDto;
import uammonitoring.server.Service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {
    private final AuthService authService;

    @Operation(summary = "로그인합니다.", description = "")
    @PostMapping("/auth/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginRequestDto requestDto) {
        TokenDto responseDto = authService.login(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
