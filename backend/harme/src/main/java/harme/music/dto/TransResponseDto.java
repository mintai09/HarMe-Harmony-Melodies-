package harme.music.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransResponseDto {
    private List<Translate> translations;
}

