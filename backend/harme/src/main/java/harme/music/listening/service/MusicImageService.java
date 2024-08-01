package harme.music.listening.service;

import harme.music.listening.dto.request.ImageRequestDto;
import harme.music.listening.dto.response.ImageResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MusicImageService {

    public ImageResponseDto generateImages(ImageRequestDto imageRequestDto) {
        String imageUrl1 = "";
        String imageUrl2 = "";

        return new ImageResponseDto(imageUrl1, imageUrl2);
    }
}
