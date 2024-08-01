package harme.music.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class MusicGenerateResponseDto {
    private String id;
    private String title;
    private String image_url;
    private String lyrics;
    private String audio_url;
    private String video_url;
    private String created_at;
    private String model_name;
    private String status;
    private String gpt_description_prompt;
    private String prompt;
    private String type;
    private String tags;
    private String duration;
    private String error_message;
}
