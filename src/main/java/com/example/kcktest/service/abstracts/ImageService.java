package com.example.kcktest.service.abstracts;

import com.example.kcktest.model.entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    Image save(MultipartFile file);

    Image getImageByUri(String imageUri);
}
