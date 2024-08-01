package harme.music.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class MusicGenerateRequestDto {
    private String tags;
    private String prompt;
    private String title;
    private String model;
    private String make_instrumental;
    private String wait_audio;

    @Builder
    MusicGenerateRequestDto(String prompt, String tags, String title, String model, String make_instrumental, String wait_audio) {
        this.prompt = prompt;
        this.tags = tags;
        this.title = title;
        this.model = model;
        this.make_instrumental = make_instrumental;
        this.wait_audio = wait_audio;
    }
}
