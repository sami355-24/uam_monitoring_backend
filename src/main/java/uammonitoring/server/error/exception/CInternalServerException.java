package uammonitoring.server.error.exception;

import lombok.Getter;
import uammonitoring.server.error.ErrorCode;

@Getter
public class CInternalServerException extends RuntimeException{
    private final ErrorCode errorCode;

    public CInternalServerException(){
        super();
        errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    }
}
