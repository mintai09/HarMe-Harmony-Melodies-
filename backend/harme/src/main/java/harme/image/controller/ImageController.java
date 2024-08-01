package harme.image.controller;

import groovy.util.logging.Slf4j;
import harme.image.dto.ImageRequestDto;
import harme.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/create")
    public String imageCreate(ImageRequestDto imageRequestDto){
        imageService.imageCreate(imageRequestDto);
        return "ok?";
    }
}
