package harme.global.exception;

import harme.global.error.ErrorCode;
import harme.global.error.ErrorResponse;
import harme.global.error.custom.RecordNotFoundException;
import org.joda.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> ioExceptionHandler(IOException e) {
        ErrorCode errorCode = ErrorCode.TRY_AGAIN;

        return ResponseEntity
                .status(errorCode.getCode())
                .body(ErrorResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                );
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> recordExceptionHandler(RecordNotFoundException e) {
        return ResponseEntity
                .status(e.getErrorCode().getCode())
                .body(ErrorResponse.builder()
                        .code(e.getErrorCode().getCode())
                        .message(e.getErrorCode().getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                );
    }
}
