package uammonitoring.server.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank
    @Schema(description = "아이디", example = "test")
    String account;
    @Length()
    @Schema(description = "비밀번호", example = "1234")
    String password;
}
