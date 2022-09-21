package com.example.kcktest.controller;

import com.example.kcktest.service.abstracts.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@Api(value = "Контроллер для работы с изображениями")
@RequestMapping(value = "", produces = "application/json")
public class ImageRestController {

    private ImageService imageService;

    @PostMapping("/saveImage")
    @ApiOperation("Загрузить картинку")
    public String saveImage(@RequestParam("file") MultipartFile image) {
        return imageService.save(image).getUri();
    }
}
