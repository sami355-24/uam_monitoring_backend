package uammonitoring.server.error.exception;

import lombok.Getter;
import uammonitoring.server.error.ErrorCode;

@Getter
public class CBadRequestException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String message;

    public CBadRequestException(String message){
        super();
        this.errorCode = ErrorCode.BAD_REQUEST;
        this.message = message;
    }
}
