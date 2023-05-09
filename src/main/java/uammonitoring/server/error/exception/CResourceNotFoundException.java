package uammonitoring.server.error.exception;

import lombok.Getter;
import uammonitoring.server.error.ErrorCode;

@Getter
public class CResourceNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public CResourceNotFoundException(){
        super();
        errorCode = ErrorCode.RESOURCE_NOT_FOUND;
    }
}
