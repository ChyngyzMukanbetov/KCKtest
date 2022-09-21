package com.example.kcktest.service.impl;

import com.example.kcktest.dao.ImageDao;
import com.example.kcktest.model.entity.Image;
import com.example.kcktest.service.abstracts.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private ImageDao imageDao;
    private StorageService storageService;

    @Override
    public Image save(MultipartFile file) {
        Image image = new Image();
        String uri = storageService.fileUpload(file);
//        image.setUri(uri);
        image.setUri("testUri");
        imageDao.save(image);
        return image;
    }

    @Override
    public Image getImageByUri(String imageUri) {
        return imageDao.getImageByUri(imageUri);
    }
}
