package harme.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    TRY_AGAIN(HttpStatus.SC_CONFLICT, "현재 사진을 업로드 할 수 없습니다. 다시 시도해 주시기 바랍니다.");

    private final int code;
    private final String message;
}
