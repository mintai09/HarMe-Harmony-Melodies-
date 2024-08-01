package harme.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TransRequestDto {
    private List<String> text;
    private String source_lang;
    private String target_lang;

    @Builder
    TransRequestDto(List<String> text, String source_lang, String target_lang) {
        this.text = text;
        this.source_lang = source_lang;
        this.target_lang = target_lang;
    }
}
