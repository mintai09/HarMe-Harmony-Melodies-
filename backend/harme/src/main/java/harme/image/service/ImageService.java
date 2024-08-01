package harme.image.service;

import harme.image.dto.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
    private final OpenAiImageModel openAiImageModel;

    public void imageCreate(ImageRequestDto imageRequestDto) {
        ImageResponse call = openAiImageModel.call(
                new ImagePrompt(makeOrder(imageRequestDto.getLyric(), imageRequestDto.getKeyword()),
                        OpenAiImageOptions.builder()
                                .withQuality("hd")
                                .withN(1)
                                .withHeight(1024)
                                .withWidth(1024)
                                .build())
        );

        log.info("url = {}", call);
    }

    private String makeOrder(String lyric, String keyword) {
        StringBuffer order = new StringBuffer();

        order.append("Create an album cover for a ")
                .append(keyword)
                .append(" song. Reflect the lyrics: ")
                .append(lyric)
                .append(".\n")
                .append("    The cover should visually represent the mood and theme of the song. Do not include any text.\n")
                .append("I want good quality.");
        return order.toString();
    }
}