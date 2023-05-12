package uammonitoring.server.Service.Impl;

import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uammonitoring.server.Config.security.jwt.JwtProvider;
import uammonitoring.server.Config.security.jwt.JwtValidator;
import uammonitoring.server.Config.security.jwt.TokenDto;
import uammonitoring.server.DTO.LoginRequestDto;
import uammonitoring.server.Entity.User;
import uammonitoring.server.Repository.UserRepository;
import uammonitoring.server.error.exception.CBadRequestException;
import uammonitoring.server.error.exception.CResourceNotFoundException;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    /**
     * 로그인합니다.
     *
     * @param requestDto 본인인증 코드, 로그인 비밀번호
     * @return 서비스 토큰 (액세스 토큰, 리프레시 토큰)
     */
    public TokenDto login(LoginRequestDto requestDto) {
        User user = userRepository.findByAccount(requestDto.getAccount()).orElseThrow(CResourceNotFoundException::new);
        if (passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            return jwtProvider.generateToken(user);
        }
        throw new CBadRequestException("잘못된 비밀번호입니다.");
    }
}
