package harme.global.error.custom;

import harme.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public RecordNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
