package harme.global.error;

import lombok.Builder;
import lombok.Getter;
import org.joda.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private final int code;
    private final String message;
    private final LocalDateTime timestamp;

}
