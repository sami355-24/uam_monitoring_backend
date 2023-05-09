package uammonitoring.server.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(-1111, "잘못된 접근입니다.", HttpStatus.BAD_REQUEST),
    RESOURCE_NOT_FOUND(-6008, "리소스를 조회할 수 없습니다.", HttpStatus.NOT_FOUND),

    JWT_INVALID(-7002, "유효하지 않은 토큰 형식입니다.", HttpStatus.UNAUTHORIZED),
    JWT_EXPIRED(-7003, "토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED),
    JWT_BLOCKED(-7004, "사용이 중지된 토큰입니다.", HttpStatus.UNAUTHORIZED),
    // 9000 ~ : 서버 에러
    INTERNAL_SERVER_ERROR(-9999, "서버 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    EMPTY(-1, "OOO", HttpStatus.INTERNAL_SERVER_ERROR);



    final int code;
    final String message;
    final HttpStatus statusCode;

    public static ErrorCode findByName(String name){
        return Arrays.stream(values())
                .filter(type -> type.name().equals(name))
                .findAny()
                .orElse(EMPTY);
    }
}
