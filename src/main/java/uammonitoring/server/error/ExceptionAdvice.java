package uammonitoring.server.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uammonitoring.server.error.exception.CBadRequestException;
import uammonitoring.server.error.exception.CResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(InterruptedException.class)
    protected ResponseEntity<ErrorResponseDto> handle(InterruptedException e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        e.printStackTrace();

        return new ResponseEntity<>(new ErrorResponseDto(errorCode), errorCode.getStatusCode());
    }

    @ExceptionHandler(CResourceNotFoundException.class)
    protected ResponseEntity<ErrorResponseDto> handle(CResourceNotFoundException e) {
        ErrorCode errorCode = e.getErrorCode();
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponseDto(errorCode), errorCode.getStatusCode());
    }

    @ExceptionHandler(CBadRequestException.class)
    protected ResponseEntity<ErrorResponseDto> handle(CBadRequestException e) {
        ErrorCode errorCode = e.getErrorCode();
        String message = e.getMessage();
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponseDto(errorCode, message), errorCode.getStatusCode());
    }
}
